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

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Elements {
    @SerializedName("start_timestamp")
    public String startTimestamp;
    private List<Before> before;
    private int line;
    private String name;
    private String description;
    private String id;
    private List<After> after;
    private String type;
    private String keyword;
    private List<Steps> steps;
    private List<Tags> tags;

    public void setStartTimestamp(String startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public String getStartTimestamp() {
        return startTimestamp;
    }

    public void setBefore(List<Before> before) {
        this.before = before;
    }

    public List<Before> getBefore() {
        return before;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setAfter(List<After> after) {
        this.after = after;
    }

    public List<After> getAfter() {
        return after;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setSteps(List<Steps> steps) {
        this.steps = steps;
    }

    public List<Steps> getSteps() {
        return steps;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public List<Tags> getTags() {
        return tags;
    }
}
