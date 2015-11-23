package by.dbmanual.utils;

import java.util.ResourceBundle;

public class InternalisationUtils {
    private static final ResourceBundle i18nBundle = ResourceBundle.getBundle("i18n");

    public static String getString(String key) {
        return i18nBundle.getString(key);
    }
}
