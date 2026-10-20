# LeetCode 2089 — Find Target Indices After Sorting Array

**Difficulty:** Easy

**Tags:** Array, Binary Search, Sorting

## Intuition

We need the indices where `target` appears after sorting the array in non-decreasing order.

Instead of sorting, count:
- how many values are smaller than `target`;
- how many values equal `target`.

The number of smaller values is the first target index. All occurrences of `target` occupy consecutive positions after sorting.

## Approach

1. Traverse the array once.
2. Count values smaller than `target` in `smaller`.
3. Count values equal to `target` in `equal`.
4. Add indices from `smaller` through `smaller + equal - 1` to the result.

## Dry Run

Input: `nums = [1, 2, 5, 2, 3]`, `target = 2`

Sorted array: `[1, 2, 2, 3, 5]`

| Item | Value |
|---|---:|
| Count of values smaller than 2 | 1 |
| Count of values equal to 2 | 2 |
| First target index | 1 |

The target occurs twice, so the indices are `1` and `2`.

Output: `[1, 2]`

## Java Solution

```java
import java.util.ArrayList;
import java.util.List;

class Solution
{
    public List<Integer> targetIndices(int[] nums, int target)
    {
        int smaller = 0;
        int equal = 0;

        for (int num : nums)
        {
            if (num < target)
            {
                smaller++;
            }
            else if (num == target)
            {
                equal++;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < equal; i++)
        {
            result.add(smaller + i);
        }

        return result;
    }
}
```

## Complexity

- **Time:** O(n), where n is the array length.
- **Auxiliary space:** O(1), excluding the result list.
- **Result space:** O(k), where k is the number of occurrences of `target`.

## Common Mistakes

- Returning the original indices instead of indices after sorting.
- Forgetting that the returned indices must be in increasing order.
- Sorting the array unnecessarily when counting is enough.

## Pattern Recognition

When a problem asks for target positions after sorting, consider whether counts can determine the positions directly—especially when only the target's indices are needed.

## Key Takeaway

The count of values smaller than the target gives its first position in the sorted array. Repeated occurrences occupy consecutive positions.

**If this explanation helped, please upvote the solution!**
