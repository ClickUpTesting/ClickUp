/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa
 */

package core.utils;

import core.utils.supplier.Supplier;
import core.utils.supplier.VoidSupplier;

public final class SpecificationProvider {

    private SpecificationProvider() {
    }

    /**
     * Checks if an request field is not null and adds the specification if so.
     *
     * @param addSpecification
     * @param getRequestField
     * @author Saul Caspa
     */
    public static void add(Supplier addSpecification, Supplier getRequestField) {
        if (getRequestField.run() != null) {
            addSpecification.run();
        }
    }

    /**
     * Checks if an request field is not null and adds the specification if so.
     *
     * @param addSpecification
     * @param getRequestField
     * @author Gustavo Huanca
     */
    public static void execute(VoidSupplier addSpecification, Supplier getRequestField) {
        if (getRequestField.run() != null) {
            addSpecification.run();
        }
    }
}
