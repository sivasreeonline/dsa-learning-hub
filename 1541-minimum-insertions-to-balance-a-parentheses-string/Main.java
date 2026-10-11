public class Main
{
    public static int minInsertions(String s)
    {
        int insertions = 0;
        int need = 0;

        for (char ch : s.toCharArray())
        {
            if (ch == '(')
            {
                // TODO: Every '(' needs two consecutive ')'.
                // If need is odd, insert one ')' first.
                // Then increase need by 2.
            }
            else
            {
                // TODO: This ')' satisfies one required ')'.
                // Decrease need. If need becomes negative,
                // insert '(' and set need to 1.
            }
        }

        // TODO: Add the closing parentheses still required.
        return insertions + need;
    }

    public static void main(String[] args)
    {
        String s = "(()))";
        System.out.println("Input: " + s);
        System.out.println("Minimum insertions: " + minInsertions(s));
    }
}
