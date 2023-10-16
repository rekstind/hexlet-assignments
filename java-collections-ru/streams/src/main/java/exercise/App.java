package exercise;

import java.util.List;

// BEGIN
public class App {

    public static long getCountOfFreeEmails(List<String> emails) {
        return emails.stream()
                .filter(email -> emailOnFreeHost(email))
                .count();
    }

    public static boolean emailOnFreeHost(String email) {
        return email.endsWith("gmail.com") || email.endsWith("hotmail.com") || email.endsWith("yandex.ru");

    }

}
// END
