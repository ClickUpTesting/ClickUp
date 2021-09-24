package clickup.utils;

public enum ObjectsNames {
    Boolean(new StringToBoolean()),
    Double(new StringToDouble()),
    Long(new StringToLong()),
    Integer(new StringToInteger()),
    Goal(new StringToGoal());

    private StringToObjectConverter stringToObjectConverter;

    ObjectsNames(final StringToObjectConverter stringToObjectConverter) {
        this.stringToObjectConverter = stringToObjectConverter;
    }

    /**
     * Gets the object StringToObjectConverter of the enum.
     *
     * @return the proper object StringToObjectConverter
     * @author Raymundo Guaraguara
     */
    public StringToObjectConverter getStringToObjectConverter() {
        return stringToObjectConverter;
    }
}
