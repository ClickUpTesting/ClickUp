package clickup.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Features {
    private Checklists checklists;
    private Emails emails;
    private DependencyWarning dependencyWarning;
    private RemapDependencies remapDependencies;
    private Sprints sprints;
    private Zoom zoom;
    private Milestones milestones;
    private CustomItems customItems;
    @JsonProperty("due_date")
    private DueDates dueDates;
    private Points points;

    public void setChecklists(Checklists checklists){
        this.checklists = checklists;
    }

    public Checklists getChecklists(){
        return checklists;
    }

    public void setEmails(Emails emails){
        this.emails = emails;
    }

    public Emails getEmails(){
        return emails;
    }

    public void setDependencyWarning(DependencyWarning dependencyWarning){
        this.dependencyWarning = dependencyWarning;
    }

    public DependencyWarning getDependencyWarning(){
        return dependencyWarning;
    }

    public void setRemapDependencies(RemapDependencies remapDependencies){
        this.remapDependencies = remapDependencies;
    }

    public RemapDependencies getRemapDependencies(){
        return remapDependencies;
    }

    public void setSprints(Sprints sprints){
        this.sprints = sprints;
    }

    public Sprints getSprints(){
        return sprints;
    }

    public void setZoom(Zoom zoom){
        this.zoom = zoom;
    }

    public Zoom getZoom(){
        return zoom;
    }

    public void setMilestones(Milestones milestones){
        this.milestones = milestones;
    }

    public Milestones getMilestones(){
        return milestones;
    }

    public void setCustomItems(CustomItems customItems){
        this.customItems = customItems;
    }

    public CustomItems getCustomItems(){
        return customItems;
    }

    public void setDueDates(DueDates dueDates){
        this.dueDates = dueDates;
    }

    public DueDates getDueDates(){
        return dueDates;
    }

    public void setPoints(Points points){
        this.points = points;
    }

    public Points getPoints(){
        return points;
    }
}