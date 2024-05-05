package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable {

    @Parameters(index = "0", description = "path to first file")
    private String filepath1;

    @Parameters(index = "1", description = "path to second file")
    private String filepath2;

    @Option(names = {"-f", "--format"},
            description = "output format [default: stylish]]")
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

    public static void main(String... args) {
        CommandLine commandLine = new CommandLine(new App());
        commandLine.usage(System.out);
    }
}
