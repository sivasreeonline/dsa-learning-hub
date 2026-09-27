# 1190. Reverse Substrings Between Each Pair of Parentheses

## LeetCode Tags
- String
- Stack

## Problem
Reverse the substring inside each matching parenthesis pair, starting with the innermost pair. The returned string must not contain parentheses.

Examples:
- `(abcd)` -> `dcba`
- `(u(love)i)` -> `iloveu`
- `(ed(et(oc))el)` -> `leetcode`

## Intuition
Instead of physically reversing substrings again and again, first match every pair of parentheses. Store the partner index for each parenthesis. During traversal, jump to the matching parenthesis and reverse the traversal direction.

## Accepted Java Solution

```java
import java.util.ArrayDeque;
import java.util.Deque;

class Solution
{
    public String reverseParentheses(String s)
    {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++)
        {
            if (s.charAt(i) == '(')
            {
                stack.push(i);
            }
            else if (s.charAt(i) == ')')
            {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuilder result = new StringBuilder();
        int direction = 1;

        for (int i = 0; i < n; i += direction)
        {
            char ch = s.charAt(i);
            if (ch == '(' || ch == ')')
            {
                i = pair[i];
                direction = -direction;
            }
            else
            {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
```

## Complexity
- Time: `O(n)` for matching parentheses and traversing the string.
- Auxiliary space: `O(n)` for the matching-index array and stack, plus the output buffer.

## Common Mistakes
- Reversing substrings repeatedly, potentially taking `O(n²)` time.
- Not recording both directions of a matching pair.
- Jumping to the matching parenthesis without flipping direction.
- Including parentheses in the output.

## Pattern
**Stack + Matching Indices + Direction Reversal** avoids repeated substring reversals.
