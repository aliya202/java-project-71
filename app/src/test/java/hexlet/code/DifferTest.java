package hexlet.code;

import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {
    private String readExpectedFilePath1 = "src/test/resources/files/file6.json";
    private Path path1 = Paths.get(readExpectedFilePath1).toAbsolutePath().normalize();
    private String readExpectedFilePath2 = "src/test/resources/files/file7.json";
    private Path path2 = Paths.get(readExpectedFilePath2).toAbsolutePath().normalize();
    private String readExpectedFilePath3 = "src/test/resources/files/file8.json";
    private Path path3 = Paths.get(readExpectedFilePath3).toAbsolutePath().normalize();
    private String readExpectedFilePath4 = "src/test/resources/files/file3.json";
    private Path path4 = Paths.get(readExpectedFilePath4).toAbsolutePath().normalize();
    private String readExpectedFilePath5 = "src/test/resources/files/file3.yml";
    private Path path5 = Paths.get(readExpectedFilePath5).toAbsolutePath().normalize();

    @Test
    public void testPlainJson() throws Exception {
        String format = "plain";
        String content1 = Files.readString(path2);
        String readFilePath1 = "src/test/resources/files/file4.json";
        String readFilePath2 = "src/test/resources/files/file5.json";
        assertEquals(content1, generate(readFilePath1, readFilePath2, format));
    }

    @Test
    public void testPlainYML() throws Exception {
        String format = "plain";
        String content1 = Files.readString(path2);
        String readFilePath1 = "src/test/resources/files/file4.yml";
        String readFilePath2 = "src/test/resources/files/file5.yml";
        assertEquals(content1, generate(readFilePath1, readFilePath2, format));
    }

    @Test
    public void testStylishJson() throws Exception {
        String format = "stylish";
        String content2 = Files.readString(path1);
        String readFilePath1 = "src/test/resources/files/file4.json";
        String readFilePath2 = "src/test/resources/files/file5.json";
        assertEquals(content2, generate(readFilePath1, readFilePath2, format));
    }

    @Test
    public void testStylishYML() throws Exception {
        String format = "stylish";
        String content2 = Files.readString(path1);
        String readFilePath1 = "src/test/resources/files/file4.yml";
        String readFilePath2 = "src/test/resources/files/file5.yml";
        assertEquals(content2, generate(readFilePath1, readFilePath2, format));
    }

    @Test
    public void testJsonJson() throws Exception {
        String format = "json";
        String content3 = Files.readString(path3);
        String readFilePath1 = "src/test/resources/files/file4.json";
        String readFilePath2 = "src/test/resources/files/file5.json";
        assertEquals(content3, generate(readFilePath1, readFilePath2, format));
    }

    @Test
    public void testJsonYML() throws Exception {
        String format = "json";
        String content3 = Files.readString(path3);
        String readFilePath1 = "src/test/resources/files/file4.yml";
        String readFilePath2 = "src/test/resources/files/file5.yml";
        assertEquals(content3, generate(readFilePath1, readFilePath2, format));
    }

    @Test
    public void testStylish() throws Exception {
        String format = "stylish";
        String content4 = Files.readString(path4);
        String readFilePath1 = "src/test/resources/files/file1.json";
        String readFilePath2 = "src/test/resources/files/file2.json";
        assertEquals(content4, generate(readFilePath1, readFilePath2, format));
    }

    @Test
    public void testStylish2() throws Exception {
        String format = "stylish";
        String content5 = Files.readString(path5);
        String readFilePath1 = "src/test/resources/files/file1.yml";
        String readFilePath2 = "src/test/resources/files/file2.yml";
        assertEquals(content5, generate(readFilePath1, readFilePath2, format));
    }
}
