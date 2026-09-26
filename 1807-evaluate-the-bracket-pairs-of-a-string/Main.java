import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main
{
    public static String evaluate(String s, List<List<String>> knowledge)
    {
        Map<String, String> map = new HashMap<>();

        // TODO 1: Add each knowledge pair to the map.
        // Example: ["name", "bob"] means name -> bob.

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
            {
                // TODO 2: Find the next ')' using indexOf.
                // TODO 3: Extract the key between '(' and ')'.
                // TODO 4: Append map.getOrDefault(key, "?").
                // TODO 5: Set i to the closing bracket's index.
            }
            else
            {
                // TODO 6: Append this character unchanged.
            }
        }

        return result.toString();
    }

    public static void main(String[] args)
    {
        List<List<String>> knowledge = new ArrayList<>();
        knowledge.add(List.of("name", "bob"));
        knowledge.add(List.of("age", "two"));

        System.out.println(evaluate("(name)is(age)yearsold", knowledge));
        // Expected: bobistwoyearsold
    }
}
