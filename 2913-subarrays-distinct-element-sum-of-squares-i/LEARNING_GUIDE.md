# LeetCode 2913 — Subarrays Distinct Element Sum of Squares I

**Difficulty:** Easy  
**Tags:** Array, Hash Table, Enumeration

## Problem in Simple Words

For every non-empty contiguous subarray, count how many distinct values it contains, square that count, and add the squares together.

## Intuition

Enumerate every possible subarray. For a fixed starting index, extend the right boundary one position at a time and maintain a set of values seen in the current subarray.

The set size gives the number of distinct elements. Add `distinctCount * distinctCount` to the answer for every extension.

## Approach

1. Initialize the answer to `0`.
2. Choose each index as the subarray's starting position.
3. Create an empty `HashSet` for that starting position.
4. Move the ending index from the start to the end of the array.
5. Add the new value to the set.
6. Add the square of the set size to the answer.
7. Return the total.

## Dry Run

Input: `nums = [1, 2, 1]`

| Subarray | Distinct values | Count | Square |
|---|---|---:|---:|
| `[1]` | `{1}` | 1 | 1 |
| `[1, 2]` | `{1, 2}` | 2 | 4 |
| `[1, 2, 1]` | `{1, 2}` | 2 | 4 |
| `[2]` | `{2}` | 1 | 1 |
| `[2, 1]` | `{1, 2}` | 2 | 4 |
| `[1]` | `{1}` | 1 | 1 |

Total: `1 + 4 + 4 + 1 + 4 + 1 = 15`

Output: `15`

## Java Solution

```java
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution
{
    public int sumCounts(List<Integer> nums)
    {
        int total = 0;

        for (int left = 0; left < nums.size(); left++)
        {
            Set<Integer> distinct = new HashSet<>();

            for (int right = left; right < nums.size(); right++)
            {
                distinct.add(nums.get(right));

                int count = distinct.size();
                total += count * count;
            }
        }

        return total;
    }
}
```

## Complexity

- **Time:** O(n²) average, because there are O(n²) subarrays and each set insertion is O(1) average.
- **Auxiliary space:** O(n) for the set in the worst case.

## Common Mistakes

- Counting subarrays only by their lengths instead of their distinct values.
- Recreating the set for every `right` index instead of once per `left` index.
- Forgetting to square the distinct count.
- Counting only unique subarrays; every index range contributes, even when two subarrays contain the same values.

## Pattern Recognition

When a problem asks for a value over every contiguous subarray and the constraints are small, consider nested loops with incremental state. A set is useful when the state is the number of distinct values.

## Key Takeaway

> Fix the left boundary, expand the right boundary, maintain a set, and add the square of its size for every subarray.

If this explanation helped, please upvote the solution!
