/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package clickup.entities;

import java.util.List;

public class Grouping {
    private String field;
    private int dir;
    private List<Object> collapsed;
    private boolean ignore;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public List<Object> getCollapsed() {
        return collapsed;
    }

    public void setCollapsed(List<Object> collapsed) {
        this.collapsed = collapsed;
    }

    public boolean isIgnore() {
        return ignore;
    }

    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }
}
