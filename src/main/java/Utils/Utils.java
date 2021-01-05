package Utils;

import java.util.Locale;

public class Utils {

    public static String toUpperCase(String string) {
        return string.toUpperCase(Locale.US);
    }

    public static float toFloat(String string) {
        string = string.replace(".","");
        string = string.replace(',','.');
        return Float.parseFloat(string);
    }
}
