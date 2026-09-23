# LeetCode 1658 — Minimum Operations to Reduce X to Zero

## Tags

- Array
- Hash Table
- Binary Search
- Sliding Window
- Prefix Sum

## Intuition

Instead of directly deciding which elements to remove from the left and right,
look at the elements that remain.

Let `total` be the sum of the entire array.

If the removed elements must sum to `x`, then the elements we keep must sum to:

```text
target = total - x
```

Therefore, the problem becomes finding the **longest contiguous subarray**
whose sum is `target`.

We want the longest one because every element outside it must be removed.

So:

```text
minimum operations = nums.length - longest valid subarray length
```

Because all numbers are positive, a sliding window can find this longest
subarray in O(n).

## Example

```text
nums = [1, 1, 4, 2, 3]
x = 5
```

Total:

```text
11
```

Target:

```text
11 - 5 = 6
```

Longest subarray with sum `6`:

```text
[1, 1, 4]
```

Its length is `3`.

Therefore:

```text
5 - 3 = 2
```

operations.

## Approach

1. Calculate the total sum.
2. Calculate `target = total - x`.
3. If `target < 0`, return `-1`.
4. If `target == 0`, return `nums.length`.
5. Use a sliding window to find the longest subarray with sum `target`.
6. Expand the window using `right`.
7. If the sum becomes greater than `target`, move `left` forward.
8. Whenever the sum equals `target`, update `maxLength`.
9. Return `nums.length - maxLength`.
10. If no valid subarray was found, return `-1`.

## Complete Solution

```java
class Solution
{
    public int minOperations(int[] nums, int x)
    {
        long total = 0;

        for (int num : nums)
        {
            total += num;
        }

        long target = total - x;

        if (target < 0)
        {
            return -1;
        }

        if (target == 0)
        {
            return nums.length;
        }

        int left = 0;
        long currentSum = 0;
        int maxLength = -1;

        for (int right = 0; right < nums.length; right++)
        {
            currentSum += nums[right];

            while (currentSum > target && left <= right)
            {
                currentSum -= nums[left];
                left++;
            }

            if (currentSum == target)
            {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength == -1 ? -1 : nums.length - maxLength;
    }
}
```

## Complexity

```text
Time Complexity: O(n)
Space Complexity: O(1)
```

Each element enters the sliding window once and leaves it at most once.

## Edge Cases

### `target < 0`

The total sum is smaller than `x`, so reaching zero is impossible.

Return `-1`.

### `target == 0`

The entire array must be removed.

Return:

```text
nums.length
```

### No valid subarray

Return:

```text
-1
```

## Common Mistakes

1. Looking for the shortest valid subarray instead of the longest.
2. Using `x` as the target instead of `total - x`.
3. Forgetting the `target == 0` case.
4. Using this sliding-window approach when negative numbers are allowed.
5. Using `int` for the total/running sum when a larger sum is possible.

## Pattern Recognition

```text
Minimum elements to REMOVE
        ↓
Maximum elements to KEEP
        ↓
Longest subarray with required sum
        ↓
Sliding Window
```

## Self-Check

1. Why is `target = total - x`?
2. Why do we find the longest subarray?
3. Why is the answer `n - maxLength`?
4. Why does sliding window work here?
5. Why are positive numbers important?
6. What happens when `target < 0`?
7. What happens when `target == 0`?
8. Why is the solution O(n)?
