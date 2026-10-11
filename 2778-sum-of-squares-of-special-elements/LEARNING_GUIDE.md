# Sum of Squares of Special Elements — Learning Guide

## Problem

An element is **special** if its 1-based index divides the array length. Return the sum of squares of all special elements.

**Example**

```text
Input:  [1, 2, 3, 4]
Output: 21
```

## Tags

`Array` `Math`

## Intuition

For array length `n`, a 1-based index is special when:

```text
n % index == 0
```

Add the square of each element at a special index.

## Dry Run

Input: `nums = [1, 2, 3, 4]`, `n = 4`

| Index (1-based) | Value | `4 % index == 0`? | Running sum |
|---:|---:|:---:|---:|
| 1 | 1 | Yes | 1 |
| 2 | 2 | Yes | 5 |
| 3 | 3 | No | 5 |
| 4 | 4 | Yes | 21 |

Output: `21`

## Optimized Java Solution

```java
class Solution
{
    public int sumOfSquares(int[] nums)
    {
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n; i++)
        {
            int index = i + 1;

            if (n % index == 0)
            {
                sum += nums[i] * nums[i];
            }
        }

        return sum;
    }
}
```

## Complexity

**Time:** `O(n)`  
**Space:** `O(1)`

## Common Mistake

The problem uses **1-based indices**, while Java arrays use **0-based indices**. Use `i + 1` for the divisibility check, but `nums[i]` to access the value.

## Key Takeaway

> Check whether the array length is divisible by each 1-based index; square and add only those elements.

If this guide helped, an upvote is appreciated.
