public class Main
{
    public static int minAddToMakeValid(String s)
    {
        int open = 0;
        int answer = 0;

        for (char ch : s.toCharArray())
        {
            if (ch == '(')
            {
                // TODO 1: Track an unmatched '('.
                open++;
            }
            else
            {
                // TODO 2: Match ')' with an available '('.
                // If none exists, we need to add an '('.
                if (open > 0)
                {
                    open--;
                }
                else
                {
                    answer++;
                }
            }
        }

        // TODO 3: Every remaining '(' needs a matching ')'.
        return answer + open;
    }

    public static void main(String[] args)
    {
        String s = "())";

        int result = minAddToMakeValid(s);

        System.out.println("Input: " + s);
        System.out.println("Minimum additions: " + result);
    }
}
