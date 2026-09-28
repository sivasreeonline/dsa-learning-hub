public class Main
{
    public static int maxDepth(String s)
    {
        int depth = 0;
        int maxDepth = 0;

        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if (ch == '(')
            {
                // TODO 1: Increase the current nesting depth.

                // TODO 2: Update maxDepth if needed.
            }
            else if (ch == ')')
            {
                // TODO 3: Decrease the current nesting depth.
            }
        }

        return maxDepth;
    }

    public static void main(String[] args)
    {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println("Maximum depth: " + maxDepth(s));
        // Expected: 3
    }
}
