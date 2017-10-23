package util;

import java.time.format.DateTimeFormatter;

public class Util {
    public static class Formatter {
        public static DateTimeFormatter yyyyDotMMdotDD           = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        public static DateTimeFormatter yyyyDotMMdotDD_hhColonMM = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
    }
}
