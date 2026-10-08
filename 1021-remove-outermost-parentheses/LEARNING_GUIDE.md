# Remove Outermost Parentheses — Learning Guide

## Problem

Remove the outermost pair of parentheses from every primitive parentheses group.

### Example

```text
Input:
"(()())"

Output:
"()()"
```

## Tags

`String` `Stack`

## Key Idea

Use a depth counter:

```text
depth = current nesting level
```

For `(`:

```text
if depth > 0 → keep
depth++
```

For `)`:

```text
depth--
if depth > 0 → keep
```

This removes the outermost pair automatically.

## Dry Run

Input:

```text
"(()())"
```

| Character | Depth Before | Action | Result |
|:---:|---:|---|---|
| `(` | 0 | Skip outer `(` | `""` |
| `(` | 1 | Keep | `(` |
| `)` | 2 | Decrease, keep | `()` |
| `(` | 1 | Keep | `()(` |
| `)` | 2 | Decrease, keep | `()()` |
| `)` | 1 | Decrease, skip outer `)` | `()()` |

Final:

```text
"()()"
```

## Optimized Java Solution

```java
class Solution
{
    public String removeOuterParentheses(String s)
    {
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char ch : s.toCharArray())
        {
            if (ch == '(')
            {
                if (depth > 0)
                {
                    result.append(ch);
                }

                depth++;
            }
            else
            {
                depth--;

                if (depth > 0)
                {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}
```

## Complexity

```text
Time  : O(n)
Space : O(n)
```

## Common Mistakes

1. Keeping the outermost `(`.
2. Checking `depth` before decreasing it for `)`.
3. Using a stack when a single counter is enough.

## Pattern Recognition

For parentheses problems, a depth counter can identify whether a character is:

```text
outermost → depth = 0
inside    → depth > 0
```

## Key Takeaway

> Use the nesting depth to skip the outermost pair of each primitive group.
