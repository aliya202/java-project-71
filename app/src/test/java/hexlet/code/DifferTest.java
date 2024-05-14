package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void differStylishTest() throws JsonProcessingException {
        String format = "stylish";
        String filepath1 = "src/test/resources/files/file1.json";
        String filepath2 = "src/test/resources/files/file2.json";
        String actual = Differ.generate(filepath1, filepath2);
        String expectedTwoCorrectFiles = "{- follow=false, host=hexlet.io, - proxy=123.234.53.22, - timeout=50," +
                " + timeout=20, + verbose=true}";
        assertEquals(expectedTwoCorrectFiles, actual);
    }
}
