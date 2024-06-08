package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String choiceFormat(Map<String, Key> difference, String format) throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.format(difference);
            case "plain" -> Plain.format(difference);
            case "json" -> Json.format(difference);
            default -> throw new Exception("Wrong format: " + format);
        };
    }
}
