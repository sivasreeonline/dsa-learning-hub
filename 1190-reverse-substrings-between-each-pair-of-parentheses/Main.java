import java.util.ArrayDeque;
import java.util.Deque;

public class Main
{
    public static String reverseParentheses(String s)
    {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        // TODO 1: Push each '(' index.
        // At ')', pop its matching '(' index and record both directions
        // in pair[].

        StringBuilder result = new StringBuilder();
        int direction = 1;

        // TODO 2: Traverse using i += direction.
        // At a parenthesis, jump to pair[i] and reverse direction.
        // At a letter, append it to result.

        return result.toString();
    }

    public static void main(String[] args)
    {
        String s = "(ed(et(oc))el)";
        System.out.println(reverseParentheses(s));
        // Expected: leetcode
    }
}
