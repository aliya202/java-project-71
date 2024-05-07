package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

import static hexlet.code.App.file1;
import static hexlet.code.App.file2;

class Differ {
    ObjectMapper objectMapper = new ObjectMapper();
    Map<String, Object> map1;
    Map<String, Object> map2;


    public static Map generate() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<HashMap<String, Object>> typeRef = new TypeReference<>() {
        };

        HashMap<String, Object> firstFile = mapper.readValue(file1, typeRef);
        HashMap<String, Object> secondFile = mapper.readValue(file2, typeRef);
        Map<String, Object> resultMap = new TreeMap<>();

        for (var f1 : firstFile.keySet()) {
            if (secondFile.containsKey(f1)) {
                if (firstFile.get(f1).equals(secondFile.get(f1))) {
                    resultMap.put(f1, firstFile.get(f1));
                } else {
                    resultMap.put(String.format("- %s", f1), firstFile.get(f1));
                    resultMap.put(String.format("+ %s", f1), secondFile.get(f1));
                }
            } else if (firstFile.containsKey(f1) && !secondFile.containsKey(f1)) {
                resultMap.put(String.format("- %s", f1), firstFile.get(f1));
            }
        }
        for (var f1 : secondFile.keySet()) {
            if (secondFile.containsKey(f1) && !firstFile.containsKey(f1)) {
                resultMap.put(String.format("+ %s", f1), secondFile.get(f1));
            }
        }
        return resultMap;
    }
}

