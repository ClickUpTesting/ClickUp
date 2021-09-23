package clickup.utils;

public class StringToInteger implements StringToObjectConverter {
    @Override
    public Object convertStringToObject(String string) {
        return Integer.valueOf(string);
    }
}
