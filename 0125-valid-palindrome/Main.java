public class Main {

    public static boolean isPalindrome(String s) {

        // TODO 1: Create two pointers.
        // One pointer should start at the beginning.
        // The other pointer should start at the end.
        //
        // Example:
        // s = "A man, a plan, a canal: Panama"
        // left  -> first character
        // right -> last character

        // TODO 2: Move the left pointer forward while the current
        // character is NOT a letter or digit.
        //
        // Hint:
        // Character.isLetterOrDigit(...)
        //
        // Example:
        // In "a,b", the comma should be skipped.

        // TODO 3: Move the right pointer backward while the current
        // character is NOT a letter or digit.

        // TODO 4: Compare the characters at left and right.
        // Ignore uppercase/lowercase differences.
        //
        // Hint:
        // Character.toLowerCase(...)
        //
        // If the characters are different, return false.

        // TODO 5: Move both pointers toward the center.
        //
        // left++;
        // right--;

        // TODO 6: If all valid characters match, return true.

        return false;
    }

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";

        boolean result = isPalindrome(s);

        System.out.println("Input: " + s);
        System.out.println("Is Palindrome: " + result);
    }
}
