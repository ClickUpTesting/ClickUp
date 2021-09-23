package clickup.utils;

public class StringToLong implements StringToObjectConverter {
    @Override
    public Object convertStringToObject(String string) {
        return Long.valueOf(string);
    }
}
