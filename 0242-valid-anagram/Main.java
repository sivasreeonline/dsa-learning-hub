import java.util.HashMap;

public class Main {

    public static boolean isAnagram(String s, String t) {

        // TODO 1: If the two strings have different lengths,
        // they cannot be anagrams.
        //
        // Example:
        // "cat" and "cats" -> false

        // TODO 2: Create a HashMap to store the frequency
        // of each character in the first string.
        //
        // Key   -> character
        // Value -> frequency/count

        // TODO 3: Traverse the first string and count
        // how many times each character appears.
        //
        // Hint:
        // You can use getOrDefault().
        //
        // Example:
        // "banana"
        // b -> 1
        // a -> 3
        // n -> 2

        // TODO 4: Traverse the second string.
        //
        // For every character:
        // - Check whether it exists in the frequency map.
        // - If it does not exist, return false.
        // - Decrease its frequency.

        // TODO 5: If a frequency becomes zero,
        // you can remove that character from the map.
        //
        // Hint:
        // frequency.remove(ch);

        // TODO 6: If all characters match correctly,
        // the map should be empty.
        //
        // Return true only when the map is empty.

        return false;
    }

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        boolean result = isAnagram(s, t);

        System.out.println("String 1: " + s);
        System.out.println("String 2: " + t);
        System.out.println("Is Anagram: " + result);
    }
}
