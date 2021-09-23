package clickup.utils;

public class StringToDouble implements StringToObjectConverter {
    @Override
    public Object convertStringToObject(String string) {
        return Double.valueOf(string);
    }
}
