package clickup.entities.features.spaces;

import clickup.entities.features.IGetAllFeatures;

import java.util.List;

public class Spaces implements IGetAllFeatures {
    private List<Space> spaces;

    @Override
    public int getAmount() {
        return spaces.size();
    }

    public List<Space> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<Space> spaces) {
        this.spaces = spaces;
    }
}
