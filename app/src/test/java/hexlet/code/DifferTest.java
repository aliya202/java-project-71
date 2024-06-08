package hexlet.code;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class DifferTest {
    private static String resultStylish;
    private static String resultPlain;
    private static String resultJson;
    private static String resultFile3Json;

    private static Path getFilePath(String fileName) {
        return Paths.get("src", "test", "resources", "files", fileName)
                .toAbsolutePath().normalize();
    }

    private static String getFileContent(String fileName) throws Exception {
        Path filePath = getFilePath(fileName);
        return Files.readString(filePath).trim();
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultFile3Json = getFileContent("file3.json");
        resultStylish = getFileContent("file6.json");
        resultPlain = getFileContent("file7.json");
        resultJson = getFileContent("file8.json");
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateTest(String format) throws Exception {
        String filePath1 = getFilePath("file1." + format).toString();
        String filePath2 = getFilePath("file2." + format).toString();
        System.out.println("File1 " + Differ.generate(filePath1, filePath2));
        // Json and Yaml to stylish as default
        assertThat(Differ.generate(filePath1, filePath2))
                .isEqualTo(resultFile3Json);
        // Json and Yaml to stylish
        assertThat(Differ.generate(filePath1, filePath2, "stylish"))
                .isEqualTo(resultFile3Json);
        // Json and Yaml to plain
        //assertThat(Differ.generate(filePath1, filePath2, "plain"))
        //        .isEqualTo(resultFile3Json);
        // Json and Yaml to json
        //assertThat(Differ.generate(filePath1, filePath2, "json"))
        //        .isEqualTo(resultJson);

        //String actualJson = Differ.generate(filePath1, filePath2, "json");
        //JSONAssert.assertEquals(resultJson, actualJson, false);
    }
}
