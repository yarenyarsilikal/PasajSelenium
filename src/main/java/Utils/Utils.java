package Utils;

import java.util.Locale;

public class Utils {

    public static String toUpperCase(String string) {
        return string.toUpperCase(Locale.US);
    }

    public static int toInt(String string) {
        return Integer.parseInt(string);
    }
}
