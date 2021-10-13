package clickup.entities.features.comment;

import clickup.entities.features.IFeature;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Comment implements IFeature {
    private long date;
    @JsonProperty("hist_id")
    private String histId;
    private int id;
    @JsonProperty("comment_text")
    private String commentText;
    private int assignee;
    @JsonProperty("notify_all")
    private boolean notifyAll;

    public void setDate(long date) {
        this.date = date;
    }

    public long getDate() {
        return date;
    }

    public void setHistId(String histId) {
        this.histId = histId;
    }

    public String getHistId() {
        return histId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public int getAssignee() {
        return assignee;
    }

    public void setAssignee(int assignee) {
        this.assignee = assignee;
    }

    public boolean isNotifyAll() {
        return notifyAll;
    }

    public void setNotifyAll(boolean notifyAll) {
        this.notifyAll = notifyAll;
    }

    @Override
    public String getIdentifier() {
        return String.valueOf(id);
    }

    @Override
    public String getRequiredField() {
        return null;
    }

    @Override
    public void setDefaultValues() {

    }
}
