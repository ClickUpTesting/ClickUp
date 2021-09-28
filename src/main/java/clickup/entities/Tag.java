package clickup.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tag implements Features {
    @JsonProperty("name")
    private String name;
    @JsonProperty("tag_fg")
    private String tagFg;
    @JsonProperty("tag_bg")
    private String tagBg;

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    private Integer creator;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("tag_fg")
    public String getTagFg() {
        return tagFg;
    }

    @JsonProperty("tag_fg")
    public void setTagFg(String tagFg) {
        this.tagFg = tagFg;
    }

    @JsonProperty("tag_bg")
    public String getTagBg() {
        return tagBg;
    }

    @JsonProperty("tag_bg")
    public void setTagBg(String tagBg) {
        this.tagBg = tagBg;
    }

}
