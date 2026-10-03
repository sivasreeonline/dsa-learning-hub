import java.util.Stack;

public class Main
{
    public static int longestValidParentheses(String s)
    {
        Stack<Integer> stack = new Stack<>();

        // TODO 1:
        // Push -1 first. It is the boundary before the string.

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
            {
                // TODO 2:
                // Push the index of '('.
            }
            else
            {
                // TODO 3:
                // Pop the matching opening-parenthesis index.

                // TODO 4:
                // If the stack is empty, this ')' is an invalid boundary.
                // Push i.

                // TODO 5:
                // Otherwise:
                // currentLength = i - stack.peek()
                // Update maxLength.
            }
        }

        return maxLength;
    }

    public static void main(String[] args)
    {
        String s = ")()())";

        int result = longestValidParentheses(s);

        System.out.println("Longest valid parentheses length: " + result);
    }
}
