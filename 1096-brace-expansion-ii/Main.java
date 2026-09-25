import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Main
{
    private static TreeSet<String> words;

    public static List<String> braceExpansionII(String expression)
    {
        words = new TreeSet<>();

        // TODO 1: Call expand(expression).

        // TODO 2: Return the TreeSet as an ArrayList.
        // TreeSet removes duplicates and keeps words sorted.
        return new ArrayList<>(words);
    }

    private static void expand(String expression)
    {
        // TODO 3: Find the first closing brace '}'.
        // If there is no closing brace, expression is a complete word.
        // Add it to words and return.

        // TODO 4: Find the matching opening brace.
        // Hint: use lastIndexOf('{', closeIndex).

        // TODO 5: Extract:
        // prefix  = text before '{'
        // choices = text inside the braces
        // suffix  = text after '}'

        // TODO 6: Split choices using ",".
        // For each choice, recursively expand:
        // prefix + choice + suffix
    }

    public static void main(String[] args)
    {
        String expression = "{a,b}{c,{d,e}}";
        List<String> result = braceExpansionII(expression);

        System.out.println(result);
        // Expected: [ac, ad, ae, bc, bd, be]
    }
}
