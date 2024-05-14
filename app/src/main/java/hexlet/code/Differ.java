package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Stream;

class Differ {

    public static String generate(String file1, String file2) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<HashMap<String, Object>> typeRef = new TypeReference<>() {
        };

        Path writeFilePath1 = Paths.get(file1);
        Path writeFilePath2 = Paths.get(file2);
        try {
            file1 = Files.readString(writeFilePath1);
            file2 = Files.readString(writeFilePath2);
        } catch (IOException e) {
            throw new RuntimeException();
        }
        HashMap<String, Object> firstFile = mapper.readValue(file1, typeRef);
        HashMap<String, Object> secondFile = mapper.readValue(file2, typeRef);
        Map<String, Object> resultMap = new LinkedHashMap<>();

        String[] allKeys = Stream.concat(firstFile.keySet().stream(), secondFile.keySet().stream())
                .distinct()
                .sorted()
                .toArray(String[]::new);

        for (String key : allKeys) {
            Object value1 = firstFile.get(key);
            Object value2 = secondFile.get(key);

            if (value1 == null) {
                if (value2 != null) {
                    resultMap.put(String.format("+ %s", key), value2);
                }
            } else if (value2 == null) {
                resultMap.put(String.format("- %s", key), value1);
            } else if (value1.equals(value2)) {
                resultMap.put(key, value1);
            } else {
                resultMap.put(String.format("- %s", key), value1);
                resultMap.put(String.format("+ %s", key), value2);
            }
        }

        return resultMap.toString();
    }
}


