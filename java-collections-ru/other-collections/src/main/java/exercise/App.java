package exercise;

import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

// BEGIN
public class App {

    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {

        SortedSet<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        return keys.stream()
                .collect(Collectors.toMap(key -> key,
                        key -> {
                            if (!data1.containsKey(key)) {
                                return "added";
                            }
                            if (!data2.containsKey(key)) {
                                return "deleted";
                            }
                            if (data1.get(key).equals(data2.get(key))) {
                                return "unchanged";
                            } else {
                                return "changed";
                            }
                        }
                        , (a, b) -> a
                        , LinkedHashMap::new));

    }
}
//END
