package clickup.utils;

import clickup.entities.Goal;
import com.google.gson.Gson;

public class StringToGoal implements StringToObjectConverter {
    /**
     * Converts a String to an object of type Goal.
     *
     * @param string with the value to convert
     * @return an object of type Goal
     */
    @Override
    public Object convertStringToObject(final String string) {
        return new Gson().fromJson(string, Goal.class);
    }
}
