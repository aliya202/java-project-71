package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


public class Differ {

    public static String generate(String file1, String file2, String format) throws Exception {

        Path path1 = Paths.get(file1).toAbsolutePath().normalize();
        Path path2 = Paths.get(file2).toAbsolutePath().normalize();

        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        Map<String, Object> data1 = Parser.parse(getFileFormat(file1), content1);
        Map<String, Object> data2 = Parser.parse(getFileFormat(file1), content2);
        Map<String, Key> difference = Comparator.compareDifference(data1, data2);
        return Formatter.chooseFormat(difference, format);
    }

    public static String getFileFormat(String file1) {
        String[] filePart;
        String delimeter = "\\.";
        filePart = file1.split(delimeter);
        return filePart[filePart.length - 1];
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        String format = "stylish";
        return generate(filePath1, filePath2, format);
    }
}


