# 70. Climbing Stairs — Learning Guide

## LeetCode Tags
- Math
- Dynamic Programming
- Memoization

## Problem in Simple Words
You are at the bottom of a staircase with `n` steps. Each move can climb either 1 or 2 steps. Return the number of distinct ways to reach the top.

## Key Observation
To reach step `n`, the final move must have come from either:
- step `n - 1`, using a 1-step move;
- step `n - 2`, using a 2-step move.

Therefore:

`ways(n) = ways(n - 1) + ways(n - 2)`

This is the Fibonacci recurrence.

## Approach
1. If `n` is 1 or 2, return `n`.
2. Keep the number of ways for the previous two steps.
3. For each step from 3 through `n`, add those two counts.
4. Shift the two stored values forward.
5. Return the count for step `n`.

Only two previous values are needed, so an array is unnecessary.

## Optimized Java Solution

```java
class Solution
{
    public int climbStairs(int n)
    {
        if (n <= 2)
        {
            return n;
        }

        int twoStepsBack = 1;
        int oneStepBack = 2;

        for (int step = 3; step <= n; step++)
        {
            int current = twoStepsBack + oneStepBack;
            twoStepsBack = oneStepBack;
            oneStepBack = current;
        }

        return oneStepBack;
    }
}
```

## Example Dry Run: `n = 5`

| Step | Ways |
|---:|---:|
| 1 | 1 |
| 2 | 2 |
| 3 | 1 + 2 = 3 |
| 4 | 2 + 3 = 5 |
| 5 | 3 + 5 = 8 |

Answer: `8`

## Complexity
- **Time:** `O(n)`
- **Auxiliary space:** `O(1)`

## Common Mistakes
- Using naive recursion, which repeats the same calculations and takes exponential time.
- Incorrectly initializing the first two states.
- Updating one previous value before calculating the new value.
- Forgetting that `n = 1` and `n = 2` are base cases.

## Pattern Recognition
This is **1D Dynamic Programming**, specifically a Fibonacci-style recurrence. When each state depends only on the previous two states, rolling variables can reduce space from `O(n)` to `O(1)`.
