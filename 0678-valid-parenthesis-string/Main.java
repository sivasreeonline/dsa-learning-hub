public class Main
{
    public static boolean checkValidString(String s)
    {
        int minOpen = 0;
        int maxOpen = 0;

        for (char ch : s.toCharArray())
        {
            if (ch == '(')
            {
                // TODO 1: Both minimum and maximum possible
                // open brackets increase by 1.
                minOpen++;
                maxOpen++;
            }
            else if (ch == ')')
            {
                // TODO 2: Both minimum and maximum possible
                // open brackets decrease by 1.
                minOpen--;
                maxOpen--;
            }
            else
            {
                // TODO 3: '*' can be ')', '(' or empty.
                // Minimum: treat '*' as ')'
                // Maximum: treat '*' as '('
                minOpen--;
                maxOpen++;
            }

            // TODO 4: If maxOpen becomes negative, even the most
            // optimistic interpretation is invalid.
            if (maxOpen < 0)
            {
                return false;
            }

            // TODO 5: The minimum possible balance cannot be negative.
            minOpen = Math.max(0, minOpen);
        }

        // TODO 6: A valid interpretation exists when the minimum
        // possible balance is exactly zero.
        return minOpen == 0;
    }

    public static void main(String[] args)
    {
        String s = "(*))";

        boolean result = checkValidString(s);

        System.out.println("Input: " + s);
        System.out.println("Valid: " + result);
    }
}
