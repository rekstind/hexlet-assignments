package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertThat(App.take(numbers1, 2))
                .hasSize(2)
                .contains(1, 2)
                .isNotEmpty();

        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        System.out.println(App.take(numbers2, 8)); // => [7, 3, 10]
        assertThat(App.take(numbers2, 8))
                .hasSizeBetween(0, 8)
                .contains(7, 3, 10)
                .isNotEmpty()
                .hasSameSizeAs(numbers2);
        // END
    }
}
