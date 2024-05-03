package hexlet.code;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.")

public class App implements Runnable {

    @Option(names = {"-h", "--help"},
            description = "Show this help message and exit.")
    private boolean helpRequested;

    @Option(names = {"-V", "--version"},
            description = "Print version information and exit.")
    private boolean versionRequested;

    @Override
    public void run() {
        System.out.println("");
    }

    public static void main(String... args) {
        System.out.println("");
    }
}
