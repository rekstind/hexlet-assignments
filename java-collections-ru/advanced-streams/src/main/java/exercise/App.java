package exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static void main(String[] args) throws IOException {
        String content = Files.readString(Path.of("/Users/daniil/Hexlet/hexlet-assignments/java-collections-ru/advanced-streams/src/main/java/exercise/s.conf"));

        // Передаем содержимое файла в метод
        String result = App.getForwardedVariables(content);
        System.out.println(result);
    }

    public static String getForwardedVariables(String content) {
        return Arrays.stream(content.split("\n"))
                .filter(s -> s.startsWith("environment="))
                .map(s -> s.replaceAll("environment=", ""))
                .map(s -> s.replaceAll("\"", ""))
                .flatMap(s -> Stream.of(s.split(","))
                        .filter(params -> params.startsWith("X_FORWARDED_"))
                        .map(params -> params.replaceAll("X_FORWARDED_", ""))
                )
                .collect(Collectors.joining(","));

    }
}
//END
