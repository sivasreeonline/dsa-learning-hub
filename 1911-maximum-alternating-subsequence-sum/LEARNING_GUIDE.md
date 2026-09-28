# 1911. Maximum Alternating Subsequence Sum — Learning Guide

## LeetCode Tags
- Array
- Dynamic Programming

## Problem in Simple Words
Choose a subsequence without changing the order of the remaining elements. Re-index the chosen elements from zero, then add elements at even indices and subtract elements at odd indices. Return the largest possible alternating sum.

Example: `nums = [4, 2, 5, 3]`. Choosing `[4, 2, 5]` gives `(4 + 5) - 2 = 7`.

## Key Idea: Two DP States
For each processed number, maintain two best results:

- `even`: best alternating sum when the next selected number can be added.
- `odd`: best alternating sum when the next selected number can be subtracted.

For a number `x`, we can skip it or select it:
- `nextEven = max(even, odd + x)`
- `nextOdd = max(odd, even - x)`

Calculate both next values from the previous states before updating either state.

## Accepted Java Solution

```java
class Solution
{
    public long maxAlternatingSum(int[] nums)
    {
        long even = 0;
        long odd = 0;

        for (int num : nums)
        {
            long nextEven = Math.max(even, odd + num);
            long nextOdd = Math.max(odd, even - num);

            even = nextEven;
            odd = nextOdd;
        }

        return even;
    }
}
```

## Dry Run: `nums = [4, 2, 5, 3]`

| Number | even before | odd before | nextEven = max(even, odd + x) | nextOdd = max(odd, even - x) |
|---:|---:|---:|---:|---:|
| 4 | 0 | 0 | 4 | 0 |
| 2 | 4 | 0 | 4 | 2 |
| 5 | 4 | 2 | 7 | 2 |
| 3 | 7 | 2 | 7 | 4 |

The maximum is `7`, achieved by subsequence `[4, 2, 5]`: `(4 + 5) - 2 = 7`.

## Complexity
- **Time:** `O(n)` — one pass.
- **Auxiliary space:** `O(1)` — two DP states.

## Common Mistakes
- Updating `even` before calculating `nextOdd`, causing the second transition to use a current-iteration value.
- Returning `odd` instead of `even`.
- Using `int` when the method returns `long`.
- Reordering elements; a subsequence must preserve relative order.

## Pattern Recognition
This is **space-optimized dynamic programming** with two states. Each number can be skipped or assigned the next positive/negative sign in the subsequence.
