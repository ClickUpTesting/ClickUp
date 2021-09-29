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

import com.fasterxml.jackson.annotation.JsonProperty;

public class Features {
    private Checklists checklists;
    private Emails emails;
    @JsonProperty("dependency_warning")
    private DependencyWarning dependencyWarning;
    @JsonProperty("remap_dependencies")
    private RemapDependencies remapDependencies;
    private Sprints sprints;
    private Zoom zoom;
    private Milestones milestones;
    @JsonProperty("custom_items")
    private CustomItems customItems;
    @JsonProperty("due_dates")
    private DueDates dueDates;
    private Points points;

    public void setChecklists(final Checklists checklists) {
        this.checklists = checklists;
    }

    public Checklists getChecklists() {
        return checklists;
    }

    public void setEmails(final Emails emails) {
        this.emails = emails;
    }

    public Emails getEmails() {
        return emails;
    }

    public void setDependencyWarning(final DependencyWarning dependencyWarning) {
        this.dependencyWarning = dependencyWarning;
    }

    public DependencyWarning getDependencyWarning() {
        return dependencyWarning;
    }

    public void setRemapDependencies(final RemapDependencies remapDependencies) {
        this.remapDependencies = remapDependencies;
    }

    public RemapDependencies getRemapDependencies() {
        return remapDependencies;
    }

    public void setSprints(final Sprints sprints) {
        this.sprints = sprints;
    }

    public Sprints getSprints() {
        return sprints;
    }

    public void setZoom(final Zoom zoom) {
        this.zoom = zoom;
    }

    public Zoom getZoom() {
        return zoom;
    }

    public void setMilestones(final Milestones milestones) {
        this.milestones = milestones;
    }

    public Milestones getMilestones() {
        return milestones;
    }

    public void setCustomItems(final CustomItems customItems) {
        this.customItems = customItems;
    }

    public CustomItems getCustomItems() {
        return customItems;
    }

    public void setDueDates(final DueDates dueDates) {
        this.dueDates = dueDates;
    }

    public DueDates getDueDates() {
        return dueDates;
    }

    public void setPoints(final Points points) {
        this.points = points;
    }

    public Points getPoints() {
        return points;
    }
}
