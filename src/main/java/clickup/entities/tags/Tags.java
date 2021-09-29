package clickup.entities.tags;

import clickup.entities.Features;
import clickup.entities.GetAllFeatures;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tags implements GetAllFeatures, Features {
    public List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public int getAmount() {
        return tags.size();
    }

}
