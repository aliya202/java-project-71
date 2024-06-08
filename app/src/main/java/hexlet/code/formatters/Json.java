package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Key;

import java.io.IOException;
import java.util.Map;

public class Json {
    public static String format(Map<String, Key> difference) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(difference);
    }
}
