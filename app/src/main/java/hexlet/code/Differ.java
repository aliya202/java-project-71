package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.App.file1;
import static hexlet.code.App.file2;

class Differ {
    ObjectMapper objectMapper = new ObjectMapper();
    Map<String, Object> map1;
    Map<String, Object> map2;


    public static Map parse(String content) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<HashMap<String, Object>> typeRef = new TypeReference<>() {};

        HashMap<String, Object> o = mapper.readValue(file1, typeRef);
        HashMap<String, Object> o1 = mapper.readValue(file2, typeRef);
        return o;
    }
}

