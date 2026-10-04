# Valid Parenthesis String — Learning Guide

## Problem

Given a string containing `(`, `)` and `*`, determine whether the string can be made valid.

The `*` can represent:

- `(`
- `)`
- empty

### Example

```text
Input:  "(*))"
Output: true
```

One possible interpretation is:

```text
(*))
(())
```

---

## Tags

`String` `Dynamic Programming` `Stack` `Greedy` `Bracket Sequence`

## Core Idea

Trying every possible meaning of `*` can become exponential.

Instead, maintain a range of possible balances:

```text
minOpen = minimum possible unmatched '('
maxOpen = maximum possible unmatched '('
```

For each character:

```text
'('  → minOpen++, maxOpen++
')'  → minOpen--, maxOpen--
'*'  → minOpen--, maxOpen++
```

For `*`:

```text
minimum → treat it as ')'
maximum → treat it as '('
```

After each character:

```java
minOpen = Math.max(0, minOpen);
```

If:

```java
maxOpen < 0
```

then no valid interpretation is possible.

At the end:

```java
minOpen == 0
```

means at least one valid interpretation exists.

---

## Dry Run

Input:

```text
"(*))"
```

| Character | minOpen | maxOpen | Explanation |
|:---:|---:|---:|---|
| `(` | 1 | 1 | Must open |
| `*` | 0 | 2 | Could be `)`, empty, or `(` |
| `)` | 0 | 1 | Close one |
| `)` | 0 | 0 | Close one |

Final:

```text
minOpen = 0
```

Therefore the answer is:

```text
true
```

---

## Optimized Java Solution

```java
class Solution
{
    public boolean checkValidString(String s)
    {
        int minOpen = 0;
        int maxOpen = 0;

        for (char ch : s.toCharArray())
        {
            if (ch == '(')
            {
                minOpen++;
                maxOpen++;
            }
            else if (ch == ')')
            {
                minOpen--;
                maxOpen--;
            }
            else
            {
                minOpen--;
                maxOpen++;
            }

            if (maxOpen < 0)
            {
                return false;
            }

            minOpen = Math.max(0, minOpen);
        }

        return minOpen == 0;
    }
}
```

## Complexity

```text
Time  : O(n)
Space : O(1)
```

## Common Mistakes

1. Treating every `*` as `(`.
2. Treating every `*` as `)`.
3. Trying all three possibilities for every `*` without considering exponential growth.
4. Forgetting to check `maxOpen < 0`.
5. Forgetting to clamp `minOpen` to zero.
6. Returning `maxOpen == 0` instead of checking `minOpen == 0`.

## Pattern Recognition

When a problem contains:

```text
wildcards + multiple possible states
```

ask:

> Can I summarize all possible states using a range instead of exploring every possibility?

Here, the entire set of possible balances is represented by:

```text
[minOpen ... maxOpen]
```

This turns the problem into an `O(n)` greedy solution.

## Key Takeaway

Do not always track every possible state.

Sometimes the **minimum and maximum possible state are enough**.

---

If this explanation helped you understand the greedy range technique, an upvote is appreciated.
