package exercise;

import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {

    public static String[][] enlargeArrayImage(String[][] image) {

        return Arrays.stream(image)
                .map(array -> Arrays.stream(array)
                        .flatMap(element -> Stream.of(element, element))
                        .toArray(String[]::new))
                .flatMap(array -> Stream.of(array, array))
                .toArray(String[][]::new);

    }
}
// END
