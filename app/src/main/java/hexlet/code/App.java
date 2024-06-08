package hexlet.code;

import lombok.Setter;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration files and shows a difference.")
@Setter
public final class App implements Callable<Integer> {

    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private String filepath1;

    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private String filepath2;

    @Option(names = {"-f", "--format"}, defaultValue = "stylish",
            description = "output format [default: ${DEFAULT-VALUE}]")
    private String format;

//    @Option(names = {"-h", "--help"},
//            description = "Show this help message and exit.")

//    @Option(names = {"-V", "--version"},
//            description = "Print version information and exit.")


    @Override
    public Integer call() throws Exception {
        try {
            String result = Differ.generate(filepath1, filepath2, format);
            System.out.println(result);
            return 0;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return 1;
        }
    }

    public static void main(String... args) {
        System.exit(new CommandLine(new App()).execute(args));
    }
}
