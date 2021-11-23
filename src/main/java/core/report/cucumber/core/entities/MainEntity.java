/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package core.report.cucumber.core.entities;

import java.util.List;

public class MainEntity {
    private List<ScenarioEntity> response;

    public void setResponse(List<ScenarioEntity> response) {
        this.response = response;
    }

    public List<ScenarioEntity> getResponse() {
        return response;
    }
}
