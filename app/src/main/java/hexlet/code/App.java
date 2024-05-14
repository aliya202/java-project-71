package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Setter;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

import static hexlet.code.Differ.generate;

@Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.")
@Setter
public class App implements Callable {

    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private String filepath1;

    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private String filepath2;

    @Option(names = {"-f", "--format"},
            description = "output format [default: stylish]]", paramLabel = "format")
    private String format;

    @Option(names = {"-h", "--help"},
            description = "Show this help message and exit.")
    private boolean helpRequested;

    @Option(names = {"-V", "--version"},
            description = "Print version information and exit.")
    private boolean versionRequested;

    @Override
    public Integer call() {
        return 0;
    }

    public static void main(String... args) throws JsonProcessingException {

        CommandLine commandLine = new CommandLine(new App());
        commandLine.usage(System.out);
        Path writeFilePath1 = Paths.get("app/src/test/resources/files/file1.json");
        Path writeFilePath2 = Paths.get("app/src/test/resources/files/file2.json");

        String file1;
        String file2;
        try {
            file1 = Files.readString(writeFilePath1);
            file2 = Files.readString(writeFilePath2);
        } catch (IOException e) {
            throw new RuntimeException();
        }
        String data = getData(file1, file2);
        System.out.println(data);

    }

    public static String getData(String file1, String file2) throws JsonProcessingException {
        return generate(file1, file2);
    }
}
