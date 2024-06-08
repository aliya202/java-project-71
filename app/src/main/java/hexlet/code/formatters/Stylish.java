package hexlet.code.formatters;

import hexlet.code.Key;

import java.util.Map;

public class Stylish {
    public static String format(Map<String, Key> differ) {

        StringBuilder str = new StringBuilder();
        str.append("{\n");
        for (Map.Entry<String, Key> element : differ.entrySet()) {

            String status = element.getValue().getStatus();
            String key = element.getKey();
            var value1 = element.getValue().getValue1();
            var value2 = element.getValue().getValue2();

            switch (status) {
                case "deleted" -> str.append("  - ").append(key).append(": ").append(value1).append("\n");
                case "added" -> str.append("  + ").append(key).append(": ").append(value2).append("\n");
                case "unchanged" -> str.append("    ").append(key).append(": ").append(value1).append("\n");
                case "changed" -> str.append("  - ").append(key).append(": ").append(value1).
                        append("\n").append("  + ").append(key).append(": ").append(value2).append("\n");
                default -> {
                    return "Something went wrong with: " + element.getValue();
                }
            }
        }
        str.append("}");
        return str.toString().trim();
    }
}
