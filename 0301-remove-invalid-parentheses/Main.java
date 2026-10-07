import java.util.*;

public class Main
{
    public static List<String> removeInvalidParentheses(String s)
    {
        List<String> answer = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty())
        {
            int size = queue.size();

            while (size-- > 0)
            {
                String current = queue.poll();

                // TODO 1:
                // Check whether the current string is valid.
                // If valid, add it to answer and set found = true.

                // TODO 2:
                // If a valid string has already been found,
                // do not generate strings for the next level.
                if (found)
                {
                    continue;
                }

                // TODO 3:
                // Remove one parenthesis at every possible position.
                // Add a new string only if it has not been visited.
                for (int i = 0; i < current.length(); i++)
                {
                    if (current.charAt(i) != '(' &&
                        current.charAt(i) != ')')
                    {
                        continue;
                    }

                    String next =
                        current.substring(0, i) +
                        current.substring(i + 1);

                    if (visited.add(next))
                    {
                        queue.offer(next);
                    }
                }
            }

            // TODO 4:
            // Stop after finding the first valid BFS level.
            if (found)
            {
                break;
            }
        }

        return answer;
    }

    public static boolean isValid(String s)
    {
        // TODO 5:
        // Use a balance counter.
        // '(' increases balance.
        // ')' decreases balance.
        // Balance must never become negative.
        // It must be zero at the end.
        return false;
    }

    public static void main(String[] args)
    {
        String s = "()())()";

        List<String> result = removeInvalidParentheses(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}
