# LeetCode 3550 — Smallest Index With Digit Sum Equal to Index

## Tags

- Array
- Math

## Intuition

We need the **smallest** index `i` such that the sum of the digits of
`nums[i]` equals `i`.

Therefore, scan the array from left to right. The first index satisfying
the condition is automatically the smallest.

For each number, calculate its digit sum using:

```text
num % 10  -> last digit
num / 10  -> remove last digit
```

## Approach

1. Traverse indices from `0` to `nums.length - 1`.
2. For each `nums[i]`, calculate its digit sum.
3. If `digitSum == i`, return `i` immediately.
4. If the complete array is processed without a match, return `-1`.

### Example

```text
nums = [1, 10, 11]
```

Index 0:

```text
digit sum(1) = 1
1 != 0
```

Index 1:

```text
digit sum(10) = 1 + 0 = 1
1 == 1
```

Return `1`.

## Complete Solution

```java
class Solution
{
    public int smallestIndex(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            int num = nums[i];
            int digitSum = 0;

            while (num > 0)
            {
                digitSum += num % 10;
                num /= 10;
            }

            if (digitSum == i)
            {
                return i;
            }
        }

        return -1;
    }
}
```

## Complexity

If `d` is the number of digits in an element:

```text
Time Complexity: O(n × d)
Space Complexity: O(1)
```

Because `nums[i] <= 1000`, `d <= 4`, so this is effectively `O(n)`.

## Edge Case

For:

```text
nums = [0]
```

the digit sum of `0` is `0`, so index `0` is valid.

The loop correctly leaves `digitSum` as `0`.

## Common Mistakes

1. Comparing `nums[i]` directly with `i` instead of comparing its digit sum.
2. Returning the last valid index instead of the first.
3. Forgetting that the digit sum of `0` is `0`.
4. Scanning in an order other than increasing index order.

## Pattern

```text
Array Traversal
      +
Digit Manipulation
      +
Early Return
```

## Self-Check

1. Why can we return immediately after finding a match?
2. What does `% 10` do?
3. What does `/ 10` do?
4. What is the digit sum of `0`?
5. Why is extra space `O(1)`?
