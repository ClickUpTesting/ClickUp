/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa
 */

package core.api;

import core.utils.Supplier;

public class ApiRequestSpecificationProvider {

    /**
     * Checks if an ApiRequestField is not null and adds the specification if so.
     *
     * @param addSpecification
     * @param getRequestField
     */
    public static void add(Supplier addSpecification, Supplier getRequestField) {
        if (getRequestField.run() != null) {
            addSpecification.run();
        }
    }
}
