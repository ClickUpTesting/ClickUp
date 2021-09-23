package clickup.utils;

public class StringToBoolean implements StringToObjectConverter {
    @Override
    public Object convertStringToObject(String string) {
        return Boolean.valueOf(string);
    }
}
