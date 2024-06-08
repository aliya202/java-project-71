package hexlet.code;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Parser {
    public static Map<String, Object> parse(String extension, String content) throws Exception {

        return switch (extension) {
            case "json" -> new ObjectMapper().readValue(content, Map.class);
            case "yml", "yaml" -> new ObjectMapper(new YAMLFactory()).readValue(content, Map.class);
            default -> throw new RuntimeException("This file can not be processed with: " + extension);
        };
    }
}
