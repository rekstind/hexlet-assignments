package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static void main(String[] args) {
        System.out.println(App.scrabble("rkqodlw", "woRld"));
    }

    public static boolean scrabble(String letters, String word) {
        boolean result = false;

        if (word.length() > letters.length()) {
            return result;
        }

        List<Character> wordCharacters = new ArrayList<>();
        for (char ch: word.toLowerCase().toCharArray()) {
            wordCharacters.add(ch);
        }

        List<Character> lettersCharacters = new ArrayList<>();
        for (char ch: letters.toCharArray()) {
            lettersCharacters.add(ch);
        }

        List<Character> wordCharactersResult = new ArrayList<>();

        for (Character wordCharacter : wordCharacters) {
            for (Character lettersCharacter : lettersCharacters) {
                if (wordCharacter == lettersCharacter) {
                    wordCharactersResult.add(wordCharacter);
                    lettersCharacters.remove(lettersCharacter);
                    break;
                }
            }
        }

        return Arrays.equals(wordCharacters.toArray(), wordCharactersResult.toArray());
    }
}

//END
