import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class Solution
{
    private TreeSet<String> words;

    public List<String> braceExpansionII(String expression)
    {
        words = new TreeSet<>();
        expand(expression);

        return new ArrayList<>(words);
    }

    private void expand(String expression)
    {
        int close = expression.indexOf('}');

        if (close == -1)
        {
            words.add(expression);
            return;
        }

        int open = expression.lastIndexOf('{', close);

        String prefix = expression.substring(0, open);
        String suffix = expression.substring(close + 1);
        String choices = expression.substring(open + 1, close);

        for (String choice : choices.split(","))
        {
            expand(prefix + choice + suffix);
        }
    }
}