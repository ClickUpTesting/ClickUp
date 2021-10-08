package clickup.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Items {
    private String Id;
    private String name;
    @JsonProperty("orderindex")
    private int orderIndex;
    private String assignee;
    private String group_assignee;
    private Boolean resolved;
    private String parent;
    private String date_created;
    private List<Object> children;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getGroup_assignee() {
        return group_assignee;
    }

    public void setGroup_assignee(String group_assignee) {
        this.group_assignee = group_assignee;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public List<Object> getChildren() {
        return children;
    }

    public void setChildren(List<Object> children) {
        this.children = children;
    }
}
