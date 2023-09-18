package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {

    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> result = new HashMap<>();

        if (sentence.isEmpty()) {
            return result;
        }

        String[] words = sentence.split(" ");

        for (String word : words) {
            Integer count = result.get(word);
            if (count == null) {
                count = 0;
            }
            count++;
            result.put(word, count);
        }

        return result;
    }

    public static String toString(Map<String, Integer> map) {

        if (map.isEmpty()) {
            return "{}";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("{\n");

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            builder.append(String.format("  %s: %s\n", pair.getKey(), pair.getValue()));
        }

        builder.append("}");

        return builder.toString();
    }

}
//END
