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

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Assignee {
    private Object profilePicture;
    private String color;
    private String initials;
    private int id;
    private String username;

    public void setProfilePicture(final Object profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Object getProfilePicture() {
        return profilePicture;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setInitials(final String initials) {
        this.initials = initials;
    }

    public String getInitials() {
        return initials;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
