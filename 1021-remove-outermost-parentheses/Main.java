public class Main
{
    public static String removeOuterParentheses(String s)
    {
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char ch : s.toCharArray())
        {
            if (ch == '(')
            {
                // TODO 1:
                // Keep '(' only when it is not the outermost
                // opening parenthesis of a primitive group.
                if (depth > 0)
                {
                    result.append(ch);
                }

                depth++;
            }
            else
            {
                // TODO 2:
                // Decrease depth first.
                depth--;

                // TODO 3:
                // Keep ')' only when it is not the outermost
                // closing parenthesis.
                if (depth > 0)
                {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args)
    {
        String s = "(()())";

        String result = removeOuterParentheses(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}
