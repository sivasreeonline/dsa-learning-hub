import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {

            // TODO 1: Check if the current character is an opening bracket.
            // Opening brackets are: (, [, {
            //
            // Hint:
            // If you see an opening bracket, store the closing bracket
            // that you expect to find later.
            //
            // Example:
            // '(' means we expect ')'
            // '[' means we expect ']'
            // '{' means we expect '}'

            // TODO 2: If the current character is a closing bracket,
            // check whether it matches the bracket expected at the top
            // of the stack.
            //
            // Hint:
            // First make sure the stack is not empty.
            // Then compare the current closing bracket with stack.peek()
            // or stack.pop().
            //
            // If they do not match, the string is invalid.

            // TODO 3: After processing all characters,
            // check whether the stack is empty.
            //
            // If the stack is empty, every opening bracket was matched.
        }

        // TODO 4: Return true only when all brackets are correctly matched.
        return false;
    }

    public static void main(String[] args) {

        String s = "({[]})";

        boolean result = isValid(s);

        System.out.println("Input: " + s);
        System.out.println("Valid: " + result);
    }
}
