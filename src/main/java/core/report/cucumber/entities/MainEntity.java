/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package core.report.cucumber.entities;

import java.util.List;

public class MainEntity {
    private List<Scenario> response;

    public void setResponse(List<Scenario> response) {
        this.response = response;
    }

    public List<Scenario> getResponse() {
        return response;
    }
}
