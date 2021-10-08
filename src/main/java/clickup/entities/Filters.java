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

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Filters {
    private String op;
    private List<String> fields;
    private String search;
    @JsonProperty("search_custom_fields")
    private boolean searchCustomFields;
    @JsonProperty("search_description")
    private boolean searchDescription;
    @JsonProperty("search_name")
    private boolean searchName;
    @JsonProperty("show_closed")
    private boolean showClosed;

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public boolean isSearchCustomFields() {
        return searchCustomFields;
    }

    public void setSearchCustomFields(boolean searchCustomFields) {
        this.searchCustomFields = searchCustomFields;
    }

    public boolean isSearchDescription() {
        return searchDescription;
    }

    public void setSearchDescription(boolean searchDescription) {
        this.searchDescription = searchDescription;
    }

    public boolean isSearchName() {
        return searchName;
    }

    public void setSearchName(boolean searchName) {
        this.searchName = searchName;
    }

    public boolean isShowClosed() {
        return showClosed;
    }

    public void setShowClosed(boolean showClosed) {
        this.showClosed = showClosed;
    }
}
