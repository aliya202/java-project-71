package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


class Differ {

    public static String generate(String file1, String file2, String format) throws Exception {

        Path fullPath1 = Paths.get(file1).toAbsolutePath().normalize();
        Path fullPath2 = Paths.get(file2).toAbsolutePath().normalize();

        String content1 = Files.readString(fullPath1);
        String content2 = Files.readString(fullPath2);


        Map<String, Object> data1 = Parser.parse(getExtension(file1), content1);
        Map<String, Object> data2 = Parser.parse(getExtension(file1), content2);
        Map<String, Key> difference = Differences.makeDifference(data1, data2);
        return Formatter.choiceFormat(difference, format);
    }
    public static String getExtension(String file1) {
        String[] fileParts;
        String delimeter = "\\.";
        fileParts = file1.split(delimeter);
        return fileParts[fileParts.length - 1];
    }
    public static String generate(String filePath1, String filePath2) throws Exception {
        String format = "stylish";
        return generate(filePath1, filePath2, format);
    }
}


