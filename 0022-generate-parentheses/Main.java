import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static List<String> generateParenthesis(int n)
    {
        List<String> result = new ArrayList<>();

        backtrack(n, 0, 0, new StringBuilder(), result);

        return result;
    }

    private static void backtrack(
        int n,
        int open,
        int close,
        StringBuilder current,
        List<String> result)
    {
        // TODO 1:
        // When current.length() == 2 * n,
        // add the completed string to result.

        // TODO 2:
        // Add '(' only when open < n.
        //
        // Remember to:
        // 1. append '('
        // 2. call backtrack(...)
        // 3. remove '(' to backtrack

        // TODO 3:
        // Add ')' only when close < open.
        //
        // Remember to:
        // 1. append ')'
        // 2. call backtrack(...)
        // 3. remove ')' to backtrack
    }

    public static void main(String[] args)
    {
        int n = 3;

        List<String> result = generateParenthesis(n);

        System.out.println(result);
    }
}
