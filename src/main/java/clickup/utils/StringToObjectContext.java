package clickup.utils;

public class StringToObjectContext {
    /**
     * Converts an object type to another.
     *
     * @param value a String with the value to convert
     * @param dataType a String with the type to convert
     * @return the value with the required data type
     */
    public static Object convertStringToObject(final String value, final String dataType) {
        if (value == null) {
            return null;
        }
        return ObjectsNames.valueOf(dataType).getStringToObjectConverter()
                .convertStringToObject(value);
    }
}
