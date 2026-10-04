# Move Zeroes — Learning Guide

## Problem

Move all zeroes to the end of the array while maintaining the relative order of the non-zero elements.

The solution must work in-place.

### Example

```text
Input:
[0, 1, 0, 3, 12]

Output:
[1, 3, 12, 0, 0]
```

## Tags

`Array` `Two Pointers`

## Key Idea

Use two pointers:

```text
left  → position where the next non-zero belongs
right → scans the array
```

When `nums[right]` is non-zero:

```text
swap(nums[left], nums[right])
left++
```

`right` always moves forward.

### Think of it as

```text
right → searches
left  → places
```

## Dry Run

Input:

```text
[0, 1, 0, 3, 12]
```

| left | right | Action | Array |
|---:|---:|---|---|
| 0 | 0 | `0` → skip | `[0,1,0,3,12]` |
| 0 | 1 | Swap `0` and `1` | `[1,0,0,3,12]` |
| 1 | 2 | `0` → skip | `[1,0,0,3,12]` |
| 1 | 3 | Swap `0` and `3` | `[1,3,0,0,12]` |
| 2 | 4 | Swap `0` and `12` | `[1,3,12,0,0]` |

Final:

```text
[1, 3, 12, 0, 0]
```

## Optimized Java Solution

```java
class Solution
{
    public void moveZeroes(int[] nums)
    {
        int left = 0;
        int right = 0;

        while (right < nums.length)
        {
            if (nums[right] != 0)
            {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
            }

            right++;
        }
    }
}
```

## Complexity

```text
Time  : O(n)
Space : O(1)
```

## Common Mistakes

1. Using an extra array.
2. Moving zeroes without preserving the order of non-zero elements.
3. Moving `left` when a zero is encountered.
4. Forgetting that `right` must always move forward.

## Pattern Recognition

When you need to:

- modify an array in-place,
- preserve the order of useful elements,
- and move unwanted elements elsewhere,

think:

```text
Two Pointers

left  → placement
right → scanning
```

## Key Takeaway

> `right` searches. `left` places.

This simple pattern appears in many in-place array problems.
