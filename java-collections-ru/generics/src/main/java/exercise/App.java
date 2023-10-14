package exercise;

import java.util.*;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static void main(String[] args) {
        List<Map<String, String>> books = new ArrayList<>();

        Map<String, String> book1 = new HashMap<>(
                Map.of("title", "Cymbeline", "author", "Shakespeare", "year", "1611")
        );
        Map<String, String> book2 = new HashMap<>(
                Map.of("title", "Book of Fooos", "author", "FooBar", "year", "1111")
        );
        Map<String, String> book3 = new HashMap<>(
                Map.of("title", "The Tempest", "author", "Shakespeare", "year", "1611")
        );
        Map<String, String> book4 = new HashMap<>(
                Map.of("title", "Book of Foos Barrrs", "author", "FooBar", "year", "2222")
        );
        Map<String, String> book5 = new HashMap<>(
                Map.of("title", "Still foooing", "author", "FooBar", "year", "3333")
        );

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        Map<String, String> where = new HashMap<>(Map.of("author", "Shakespeare", "year", "1611"));

        List<Map<String, String>> result = findWhere(books, where);

        System.out.println(result); // =>

    }

    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();

        for (Map<String, String> book : books) {
            boolean allKeyFound = true;
            for (Entry<String, String> searchPair : where.entrySet()) {
                String bookValue = book.get(searchPair.getKey());
                if (!bookValue.equals(searchPair.getValue())) {
                    allKeyFound = false;
                }
            }

            if (allKeyFound) {
                result.add(book);
            }
        }
        return result;
    }
}
//END
