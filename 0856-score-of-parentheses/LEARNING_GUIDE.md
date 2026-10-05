# Score of Parentheses — Learning Guide

## Problem

Given a balanced parentheses string, calculate its score.

```text
()    → 1
AB    → A + B
(A)   → 2 × A
```

### Example

```text
Input:  "(()())"
Output: 4
```

## Tags

`String` `Stack`

## Key Idea

We can avoid using an actual stack.

Maintain:

```text
depth → current nesting level
score → total score
```

When we find an immediate `()` pair at depth `d`:

```text
score += 2^(d - 1)
```

In Java:

```java
score += 1 << (depth - 1);
```

## Dry Run

Input:

```text
"(()())"
```

| Character | Depth Before | Action | Score |
|:---:|---:|---|---:|
| `(` | 0 | Open | 0 |
| `(` | 1 | Open | 0 |
| `)` | 2 | `()` → add `2` | 2 |
| `(` | 1 | Open | 2 |
| `)` | 2 | `()` → add `2` | 4 |
| `)` | 1 | Close | 4 |

Final score:

```text
4
```

## Optimized Java Solution

```java
class Solution
{
    public int scoreOfParentheses(String s)
    {
        int depth = 0;
        int score = 0;

        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if (ch == '(')
            {
                depth++;
            }
            else
            {
                if (s.charAt(i - 1) == '(')
                {
                    score += 1 << (depth - 1);
                }

                depth--;
            }
        }

        return score;
    }
}
```

## Complexity

```text
Time  : O(n)
Space : O(1)
```

## Common Mistakes

1. Adding a score for every `)`.
2. Forgetting that only an immediate `()` contributes a new base score.
3. Using `depth` after decreasing it instead of before decreasing it.
4. Confusing nesting with concatenation.

## Pattern Recognition

When a parentheses problem asks for a value based on nesting, look for:

```text
depth
+
immediate "()"
+
nested multiplication
```

Here, every additional level doubles the score.

## Key Takeaway

> `()` gives 1, and every surrounding pair doubles its score.
