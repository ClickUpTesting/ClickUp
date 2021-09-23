package core.utils;

public class LowerCamelCaseConverter {
    /**
     * Converts a string to Lower Camel Case format.
     *
     * @param value a string
     * @return the string with lower camel case format
     * @author Raymundo Guaraguara
     */
    public static String convertToLowerCamelCase(final String value) {
        String[] words = value.split("\\s");
        String lowerCamelCaseWord = "";
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                lowerCamelCaseWord = lowerCamelCaseWord.concat(words[i].toLowerCase());
            } else {
                lowerCamelCaseWord = lowerCamelCaseWord.concat(words[i].substring(0,1).toUpperCase()
                        .concat(words[i].substring(1).toLowerCase()));
            }
        }
        return lowerCamelCaseWord;
    }
}
