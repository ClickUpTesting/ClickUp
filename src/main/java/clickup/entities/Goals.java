package clickup.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Goals implements IFeatures {
    private Goal goal;

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    @Override
    public String toString() {
        return "Goals{" +
                "goal=" + goal +
                '}';
    }

    @Override
    public String getIdentifier() {
        return null;
    }
}
