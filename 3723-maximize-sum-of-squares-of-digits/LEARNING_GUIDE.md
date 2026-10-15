# LeetCode 3723 — Maximize Sum of Squares of Digits

**Difficulty:** Medium

**Tags:** Math, Greedy, String, Number Construction

## Problem in Simple Words

Given two positive integers, `num` and `sum`, construct a positive integer with exactly `num` digits whose digits add up to `sum`.

The score is the sum of the squares of its digits. Return the number as a string that maximizes this score. If several numbers have the same maximum score, return the numerically largest one. If no valid number exists, return an empty string.

## Intuition

To maximize the sum of squared digits, concentrate the digit sum into the largest digits possible. A digit cannot exceed `9`, so choose as many `9`s as possible, then use the remaining sum as one digit, and fill unused positions with zeroes.

Putting the largest digits first also gives the largest number when scores tie.

## Approach

1. If `sum > 9 * num`, no valid number can be formed, so return an empty string.
2. While `sum` is greater than zero, choose `min(9, sum)`.
3. Append that digit and subtract it from `sum`.
4. Reduce the number of remaining digit positions each time a digit is added.
5. Append zeroes for all remaining positions.
6. Return the result as a string.

## Dry Run

Input: `num = 2`, `sum = 3`

| Step | Remaining sum | Digit added | Result |
|---|---:|---:|---|
| 1 | 3 | 3 | `"3"` |
| 2 | 0 | 0 | `"30"` |

The result has two digits and their sum is 3. Its score is 3 × 3 + 0 × 0 = 9.

## Accepted Java Solution

```java
class Solution
{
    public String maxSumOfSquares(int num, int sum)
    {
        if (sum > 9 * num)
        {
            return "";
        }

        StringBuilder result = new StringBuilder();

        while (sum > 0)
        {
            int digit = Math.min(9, sum);

            result.append(digit);
            sum -= digit;
            num--;
        }

        while (num > 0)
        {
            result.append('0');
            num--;
        }

        return result.toString();
    }
}
```

## Complexity

- **Time:** O(num), because the result has `num` digits when a solution exists.
- **Auxiliary space:** O(num) for building the output string.

## Common Mistakes

- Forgetting that each digit is at most 9.
- Returning a number with fewer than `num` digits.
- Appending zeroes before using the available digit sum.
- Returning `"0"` instead of an empty string when the required sum cannot fit in the available digits.
- Forgetting to return a string.

## Pattern Recognition

Use this greedy pattern when a problem asks you to maximize a digit-based score subject to a fixed number of digits and a fixed digit sum. Giving more sum to a larger digit increases the sum of squares, so fill the largest digit first.

## Key Takeaway

**Use as many 9s as possible, then the remaining digit, then zeroes.** This maximizes the squared-digit score and places larger digits earlier.

If this explanation helped, please upvote the solution.
