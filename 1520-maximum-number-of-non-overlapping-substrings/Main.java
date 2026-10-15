import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main
{
    public static List<String> maxNumOfSubstrings(String s)
    {
        int[] first = new int[26];
        int[] last = new int[26];

        // TODO 1: Mark unseen characters in first[] with -1.
        // Hint: Arrays.fill(first, -1).

        // TODO 2: Record the first and last index of every character.
        for (int i = 0; i < s.length(); i++)
        {
            int c = s.charAt(i) - 'a';
            // Set first[c] only if this is its first occurrence.
            // Always update last[c].
        }

        List<int[]> intervals = new ArrayList<>();

        // TODO 3: Build the smallest valid interval for each present character.
        for (int c = 0; c < 26; c++)
        {
            if (first[c] == -1)
            {
                continue;
            }

            int left = first[c];
            int right = last[c];
            boolean valid = true;

            // TODO 4: Scan from left to right, expanding right when needed.
            // If first[ch] < left, this interval is invalid.
            for (int i = left; i <= right; i++)
            {
                int ch = s.charAt(i) - 'a';
                // Validate first[ch] and expand right to include last[ch].
            }

            // TODO 5: Add each valid interval as {left, right}.
        }

        // TODO 6: Sort intervals by their ending index.
        // Hint: intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> answer = new ArrayList<>();
        int previousEnd = -1;

        // TODO 7: Greedily select intervals that do not overlap.
        // An interval is compatible when its left endpoint > previousEnd.
        // Add s.substring(left, right + 1), then update previousEnd.

        return answer;
    }

    public static void main(String[] args)
    {
        String s = "adefaddaccc";
        List<String> result = maxNumOfSubstrings(s);

        System.out.println("Input: " + s);
        System.out.println("Selected substrings: " + result);
        System.out.println("Count: " + result.size());
    }
}
