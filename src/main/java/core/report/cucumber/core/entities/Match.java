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

public class Match {
    private String location;
    private List<Arguments> arguments;

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setArguments(List<Arguments> arguments) {
        this.arguments = arguments;
    }

    public List<Arguments> getArguments() {
        return arguments;
    }
}
