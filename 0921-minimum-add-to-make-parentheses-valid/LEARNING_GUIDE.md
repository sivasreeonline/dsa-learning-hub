# Minimum Add to Make Parentheses Valid — Learning Guide

## Problem

Find the minimum number of parentheses that must be added to make the string valid.

### Example

```text
Input:  "())"
Output: 1
```

## Tags

`String` `Stack` `Greedy` `Parentheses`

## Key Idea

Track two things:

```text
open   → unmatched '('
answer → parentheses we need to add
```

For each character:

```text
'(' → open++

')' → if open > 0, open--
      otherwise answer++
```

At the end, remaining `(` need `)`:

```text
answer + open
```

## Dry Run

Input:

```text
"())"
```

| Character | open | answer | Action |
|:---:|---:|---:|---|
| `(` | 1 | 0 | Store unmatched `(` |
| `)` | 0 | 0 | Match the `(` |
| `)` | 0 | 1 | Need an extra `(` |

Final answer:

```text
1
```

## Optimized Java Solution

```java
class Solution
{
    public int minAddToMakeValid(String s)
    {
        int open = 0;
        int answer = 0;

        for (char ch : s.toCharArray())
        {
            if (ch == '(')
            {
                open++;
            }
            else
            {
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

        return answer + open;
    }
}
```

## Complexity

```text
Time  : O(n)
Space : O(1)
```

## Common Mistakes

1. Counting only unmatched `(`.
2. Forgetting that an unmatched `)` needs an `(`.
3. Forgetting the remaining unmatched `(` at the end.
4. Using a stack when a counter is sufficient.

## Pattern Recognition

For minimum-parentheses problems, track:

```text
unmatched ')'
+
unmatched '('
```

These directly determine the minimum additions.

## Key Takeaway

> Every unmatched `)` needs an `(`, and every unmatched `(` needs a `)`.
