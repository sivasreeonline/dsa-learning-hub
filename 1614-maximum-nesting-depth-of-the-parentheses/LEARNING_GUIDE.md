# 1614. Maximum Nesting Depth of the Parentheses — Learning Guide

## LeetCode Tags
- String
- Stack

## Problem in Simple Words
Return the maximum number of parentheses that are open at the same time.

Example: `(1+(2*3)+((8)/4))+1` has a maximum nesting depth of `3`.

## Key Idea
Track the current depth while scanning:
- On `(`, increase depth.
- On `)`, decrease depth.
- Whenever depth increases, update the maximum.

The input is guaranteed to be valid, so a counter is enough; an actual stack is unnecessary.

## Accepted Java Solution

```java
class Solution
{
    public int maxDepth(String s)
    {
        int depth = 0;
        int maxDepth = 0;

        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if (ch == '(')
            {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            }
            else if (ch == ')')
            {
                depth--;
            }
        }

        return maxDepth;
    }
}
```

## Example Dry Run
Input: `(1+(2*3)+((8)/4))+1`

| Event | Current depth | Maximum depth |
|---|---:|---:|
| First `(` | 1 | 1 |
| Second `(` | 2 | 2 |
| Third `(` | 3 | 3 |
| Matching `)` | 2 | 3 |
| Matching `)` | 1 | 3 |
| Final matching `)` | 0 | 3 |

Output: `3`

## Complexity
- **Time:** `O(n)` — one scan.
- **Auxiliary space:** `O(1)` — two counters.

## Common Mistakes
- Returning the final depth (a valid string finishes at zero).
- Counting all parentheses rather than simultaneously open ones.
- Using a stack when a counter is sufficient.
- Updating the maximum only after closing parentheses.

## Pattern Recognition
**String Traversal + Counter.** For valid balanced parentheses, track current depth and maximum depth instead of storing the full stack.
