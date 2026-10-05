public class Main
{
    public static int scoreOfParentheses(String s)
    {
        int depth = 0;
        int score = 0;

        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if (ch == '(')
            {
                // TODO 1: Increase the nesting depth.
                depth++;
            }
            else
            {
                // TODO 2: If this ')' closes an immediate "()",
                // add 2^(depth - 1) to the score.
                // Hint: Check whether the previous character is '('.

                // TODO 3: Decrease the nesting depth.
                depth--;
            }
        }

        return score;
    }

    public static void main(String[] args)
    {
        String s = "(()())";

        int result = scoreOfParentheses(s);

        System.out.println("Input: " + s);
        System.out.println("Score: " + result);
    }
}
