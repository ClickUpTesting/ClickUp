/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.entities;

public class Project {
    private boolean access;
    private boolean hidden;
    private String name;
    private String id;

    public void setAccess(boolean access) {
        this.access = access;
    }

    public boolean isAccess() {
        return access;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
