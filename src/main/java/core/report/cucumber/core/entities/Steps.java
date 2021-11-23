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

public class Steps {
    private Result result;
    private int line;
    private String name;
    private Match match;
    private String keyword;
    private List<RowsItem> rows;

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getLine() {
        return line;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Match getMatch() {
        return match;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setRows(List<RowsItem> rows) {
        this.rows = rows;
    }

    public List<RowsItem> getRows() {
        return rows;
    }
}
