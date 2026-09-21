# LeetCode 3524 — Find X Value of Array I

## 1. Problem in Simple Words

The operation removes a prefix and a suffix while leaving a non-empty array.

Every possible operation therefore corresponds to choosing one non-empty contiguous subarray.

We need to count those subarrays according to:

`product of subarray % k`

The answer is an array of size `k`.

## 2. Key Observation

Instead of thinking about removing prefixes and suffixes, think:

> Count every non-empty contiguous subarray by the remainder of its product modulo `k`.

There can be O(n²) subarrays, so brute force is too slow for `n = 100000`.

The important constraint is:

`k <= 5`

That means there are only a few possible product remainders.

## 3. DP State

We maintain:

`dp[r]`

meaning:

> The number of subarrays ending at the previous position whose product modulo `k` is `r`.

For example, when `k = 3`:

- `dp[0]` → product remainder 0
- `dp[1]` → product remainder 1
- `dp[2]` → product remainder 2

## 4. Process Each Number

For every `num`, there are two possibilities.

### A. Start a new subarray

The subarray `[num]` has:

`num % k`

So:

`next[num % k]++`

### B. Extend every previous subarray

If a previous subarray has product remainder `r`, appending `num` gives:

`newRemainder = (r * num) % k`

So:

`next[newRemainder] += dp[r]`

We use `next` because it represents all subarrays ending at the current position.

## 5. Update the DP

After processing `num`:

`dp = next`

Conceptually:

```text
Previous position
       |
      dp
       |
   add num
       |
     next
       |
Current position
```

## 6. Update the Final Answer

Every subarray counted in `next` is a valid remaining subarray.

Therefore:

`result[r] += next[r]`

At the end:

`result[r]`

contains the total number of non-empty subarrays whose product modulo `k` equals `r`.

## 7. Dry Run

For:

```text
nums = [1, 2, 3, 4, 5]
k = 3
```

Initially:

```text
dp     = [0, 0, 0]
result = [0, 0, 0]
```

After processing `1`:

```text
[1] -> 1 % 3 = 1

next = [0, 1, 0]
```

After processing `2`, the new subarray is `[2]`, and `[1]` can be extended to `[1,2]`.

Both have remainder `2`:

```text
[2]     -> 2 % 3 = 2
[1,2]   -> 2 % 3 = 2

next = [0, 0, 2]
```

The same transition continues for every number.

Final result:

```text
[9, 2, 4]
```

## 8. Why We Need `next`

Do not update `dp` while iterating through its states.

`dp` describes the previous position.

`next` describes the current position.

Only after all transitions are calculated do we copy:

```text
dp[r] = next[r]
```

## 9. Complexity

For every number, we inspect at most `k` remainder states.

Time:

`O(n × k)`

Since `k <= 5`, this is effectively `O(n)`.

Space:

`O(k)`

We only maintain arrays whose size depends on `k`.

## 10. Why Brute Force Is Too Slow

An array of length `n` has:

`n(n + 1) / 2`

non-empty subarrays.

For `n = 100000`, that is about 5 billion subarrays.

The DP solution avoids explicitly generating every subarray.

## 11. Common Mistakes

### Mistake 1 — Forgetting single-element subarrays

Every number can start a new subarray:

```java
next[remainder]++;
```

### Mistake 2 — Updating `dp` too early

Build the complete `next` array first.

Then update `dp`.

### Mistake 3 — Confusing `dp` and `result`

`dp` = subarrays ending at the current position.

`result` = totals across the whole array.

### Mistake 4 — Forgetting modulo

The transition is:

```text
(r * num) % k
```

### Mistake 5 — Integer multiplication

Use:

```java
(r * 1L * num)
```

so multiplication is performed using `long`.

## 12. Student Challenge

Complete the TODOs in `Main.java`.

Test:

```text
nums = [1, 2, 3, 4, 5]
k = 3
Expected = [9, 2, 4]
```

Then test:

```text
nums = [1, 2, 4, 8, 16, 32]
k = 4
Expected = [18, 1, 2, 0]
```

And:

```text
nums = [1, 1, 2, 1, 1]
k = 2
Expected = [9, 6]
```

## 13. Self-Check

Before moving on, make sure you can explain:

1. What does `dp[r]` represent?
2. Why do we create `next`?
3. Why is `num % k` used for a new subarray?
4. How do we calculate the new remainder?
5. Why do we add `next[r]` to `result[r]`?
6. Why is the complexity `O(n × k)`?
7. Why is the extra space `O(k)`?

If you can explain these points, you understand the DP pattern used in this problem.
