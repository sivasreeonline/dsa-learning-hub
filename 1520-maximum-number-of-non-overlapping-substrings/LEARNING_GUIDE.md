# LeetCode 1520 — Maximum Number of Non-Overlapping Substrings

**Difficulty:** Hard  
**Tags:** String, Greedy, Hash Table, Interval

## Problem in Simple Words

Choose as many non-empty, non-overlapping substrings as possible. If a chosen substring contains a character, it must contain every occurrence of that character in the entire string.

If multiple answers contain the same maximum number of substrings, choose the one with the minimum total length. The substrings can be returned in any order.

## Intuition

A substring is valid only when every character inside it has all its occurrences inside that same substring.

For each character, start with its first and last occurrences. Scan that interval and expand its right boundary whenever a character inside it occurs farther to the right. If a character inside the interval first appeared before the interval's left boundary, the candidate is invalid.

After generating valid intervals, sort them by ending position and greedily select compatible intervals. Choosing the earliest finishing interval leaves the most room for later substrings.

## Approach

1. Record the first and last occurrence of each lowercase letter.
2. For every character that occurs, construct its candidate interval.
3. Scan the interval, expanding its right boundary to include all occurrences of each character encountered.
4. Reject the candidate if an inner character first appeared before the candidate's left boundary.
5. Sort valid intervals by ending index.
6. Greedily choose each interval whose start is after the end of the previously selected interval.
7. Convert the chosen intervals to substrings.

## Dry Run

Input: `s = "adefaddaccc"`

| Character | Candidate substring | Interval |
|---|---|---|
| `e` | `"e"` | `[2, 2]` |
| `f` | `"f"` | `[3, 3]` |
| `c` | `"ccc"` | `[8, 10]` |

Selected substrings:

| Substring | Start | End |
|---|---:|---:|
| `"e"` | 2 | 2 |
| `"f"` | 3 | 3 |
| `"ccc"` | 8 | 10 |

Output: `["e", "f", "ccc"]`

The substrings do not overlap, and each contains every occurrence of its character.

## Java Solution

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution
{
    public List<String> maxNumOfSubstrings(String s)
    {
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);

        for (int i = 0; i < s.length(); i++)
        {
            int c = s.charAt(i) - 'a';

            if (first[c] == -1)
            {
                first[c] = i;
            }

            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for (int c = 0; c < 26; c++)
        {
            if (first[c] == -1)
            {
                continue;
            }

            int left = first[c];
            int right = last[c];
            boolean valid = true;

            for (int i = left; i <= right; i++)
            {
                int ch = s.charAt(i) - 'a';

                if (first[ch] < left)
                {
                    valid = false;
                    break;
                }

                right = Math.max(right, last[ch]);
            }

            if (valid)
            {
                intervals.add(new int[]{left, right});
            }
        }

        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> answer = new ArrayList<>();
        int previousEnd = -1;

        for (int[] interval : intervals)
        {
            if (interval[0] > previousEnd)
            {
                answer.add(
                    s.substring(interval[0], interval[1] + 1)
                );

                previousEnd = interval[1];
            }
        }

        return answer;
    }
}
```

## Complexity

- **Time:** O(n + 26²), effectively O(n) for the fixed lowercase English alphabet.
- **Auxiliary space:** O(1) for the character arrays, because the alphabet size is fixed. Candidate intervals and returned substrings require additional space.

## Common Mistakes

- Assuming every first-to-last interval is automatically valid.
- Forgetting to expand the right boundary when an inner character appears later.
- Keeping an interval when an inner character first appeared before its left boundary.
- Sorting by start instead of end before greedy selection.
- Rejecting adjacent intervals: use `left > previousEnd`, so adjacent substrings are allowed.

## Pattern Recognition

Look for this combination when a problem asks for maximum non-overlapping substrings with character-occurrence constraints:

- First/last occurrence boundaries
- Interval expansion and validation
- Greedy interval scheduling by earliest ending position

## Key Takeaway

> Build the smallest valid intervals first. Then sort by ending position and greedily choose compatible intervals.

If this explanation helped, please upvote the solution!
