# Minimum Insertions to Balance a Parentheses String

## Problem
Every `(` must be matched with two consecutive `))`. Return the minimum insertions needed.

**Example:** `s = "(()))"` → `1`

## Tags
`String` `Greedy` `Stack`

## Intuition
Track how many closing parentheses are still needed:
- `need`: remaining `)` required.
- `insertions`: characters inserted.

For `(`, we need two `)`. If `need` is odd, insert one `)` first. For `)`, decrease `need`. If it becomes negative, insert `(` and set `need = 1`. Finally, add the remaining `need` to `insertions`.

## Dry Run
Input: `"(()))"`

| Character | need before | Action | need after | Insertions |
|:---:|---:|---|---:|---:|
| `(` | 0 | Need two `)` | 2 | 0 |
| `(` | 2 | Need two more `)` | 4 | 0 |
| `)` | 4 | One `)` supplied | 3 | 0 |
| `)` | 3 | One `)` supplied | 2 | 0 |
| `)` | 2 | One `)` supplied | 1 | 0 |

One `)` is still needed: answer = `0 + 1 = 1`.

## Optimized Java Solution
```java
class Solution
{
    public int minInsertions(String s)
    {
        int insertions = 0;
        int need = 0;

        for (char ch : s.toCharArray())
        {
            if (ch == '(')
            {
                if (need % 2 == 1)
                {
                    insertions++;
                    need--;
                }

                need += 2;
            }
            else
            {
                need--;

                if (need < 0)
                {
                    insertions++;
                    need = 1;
                }
            }
        }

        return insertions + need;
    }
}
```

## Complexity
**Time:** `O(n)`  
**Space:** `O(1)`

## Common Mistakes
1. Treating this like ordinary parentheses, where `(` needs only one `)`.
2. Forgetting to make `need` even before processing a new `(`.
3. Forgetting to handle `need < 0`.
4. Forgetting to add the remaining `need` at the end.

## Key Takeaway
> Each `(` needs two consecutive `)`. Track required closings instead of using a stack.
