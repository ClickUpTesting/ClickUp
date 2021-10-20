package clickup.entities.valuesdefects;

import java.util.HashMap;
import java.util.Map;

public final class PriorityDefault {
    private PriorityDefault() {

    }

    /**
     * Values by default in the priority.
     *
     * @param priorityValue value to get equivalent
     * @return a value corresponds priorityValue
     */
    public static String priorityDefault(final String priorityValue) {
        Map<String, String> priorityMap = new HashMap<>();
        priorityMap.put("1", "urgent");
        priorityMap.put("2", "high");
        priorityMap.put("3", "normal");
        priorityMap.put("4", "low");
        priorityMap.put("urgent", "1");
        priorityMap.put("high", "2");
        priorityMap.put("normal", "3");
        priorityMap.put("low", "4");
        return priorityMap.get(priorityValue);
    }
}
