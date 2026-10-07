# Remove Invalid Parentheses — Learning Guide

## Problem

Remove the minimum number of parentheses to make the string valid.

Return all unique valid results.

### Example

```text
Input:
"()())()"

Output:
["(())()", "()()()"]
```

## Tags

`String` `Backtracking` `Breadth-First Search`

## Key Idea

Think in levels:

```text
Level 0 → remove 0 parentheses
Level 1 → remove 1 parenthesis
Level 2 → remove 2 parentheses
...
```

The first level containing valid strings gives the minimum removals.

Use:

```text
Queue → BFS
Set   → avoid duplicates
```

## Approach

1. Put the original string into the queue.
2. Process the current BFS level.
3. If a string is valid, add it to the answer.
4. Once a valid level is found, stop creating deeper levels.
5. Otherwise, remove one parenthesis at each possible position.
6. Use a `Set` to avoid duplicate strings.

## Dry Run

Input:

```text
"()())()"
```

| Level | Action | Result |
|---:|---|---|
| 0 | Original | `()())()` |
| 1 | Remove one parenthesis | Several candidates |
| 1 | Valid strings found | `(())()` and `()()()` |

Because valid strings are found at Level 1, we stop.

```text
Answer = ["(())()", "()()()"]
```

## Optimized Java Solution

```java
import java.util.*;

class Solution
{
    public List<String> removeInvalidParentheses(String s)
    {
        List<String> answer = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty())
        {
            int size = queue.size();

            while (size-- > 0)
            {
                String current = queue.poll();

                if (isValid(current))
                {
                    answer.add(current);
                    found = true;
                }

                if (found)
                {
                    continue;
                }

                for (int i = 0; i < current.length(); i++)
                {
                    if (current.charAt(i) != '(' &&
                        current.charAt(i) != ')')
                    {
                        continue;
                    }

                    String next =
                        current.substring(0, i) +
                        current.substring(i + 1);

                    if (visited.add(next))
                    {
                        queue.offer(next);
                    }
                }
            }

            if (found)
            {
                break;
            }
        }

        return answer;
    }

    private boolean isValid(String s)
    {
        int balance = 0;

        for (char ch : s.toCharArray())
        {
            if (ch == '(')
            {
                balance++;
            }
            else if (ch == ')')
            {
                balance--;

                if (balance < 0)
                {
                    return false;
                }
            }
        }

        return balance == 0;
    }
}
```

## Complexity

```text
Time  : O(2^n × n)
Space : O(2^n × n)
```

## Common Mistakes

1. Continuing after finding a valid BFS level.
2. Not using a `Set` to remove duplicates.
3. Removing letters instead of only parentheses.
4. Accepting a string when the final balance is zero but the balance became negative earlier.

## Pattern Recognition

When every operation has the same cost and the problem asks for a minimum number of operations:

```text
Level 0 → 0 operations
Level 1 → 1 operation
Level 2 → 2 operations
```

BFS naturally finds the minimum level.

## Key Takeaway

> BFS level represents the number of removals. The first valid level gives the minimum.
