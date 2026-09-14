# Best Time to Buy and Sell Stock — Learning Guide

## 1. What is the Problem?

You are given an array `prices`, where:

- `prices[i]` = stock price on day `i`
- You may buy **once**
- You may sell **once**
- You must **buy before you sell**
- Your goal is to find the **maximum possible profit**

If no profitable transaction is possible, return `0`.

### Example

```text
Input:  [7, 1, 5, 3, 6, 4]
Output: 5
```

The best transaction is:

```text
Buy  at 1
Sell at 6

Profit = 6 - 1 = 5
```

---

## 2. Think About the Real Challenge

At first, you might think:

> "For every day, try selling on every future day."

That means checking many possible buy/sell combinations.

For an array of `n` prices, this can take:

```text
O(n²)
```

time.

Can we do better?

Yes!

The key is to realize that when we are considering selling **today**, we only need to know:

> What is the lowest price I have seen before today?

---

## 3. The Key Idea

While scanning the array from left to right, maintain two pieces of information:

### Minimum price so far

This represents the best price at which we could have bought before the current day.

```text
minPrice
```

### Maximum profit so far

This represents the best profit we have found up to the current day.

```text
maxProfit
```

For every price:

```text
profit = current price - minimum price so far
```

Then update the best profit.

---

## 4. Example Walkthrough

Consider:

```text
prices = [7, 1, 5, 3, 6, 4]
```

Start with:

```text
minPrice = 7
maxProfit = 0
```

### Day 1 — Price = 1

`1` is lower than our current minimum.

```text
minPrice = 1
```

No profit yet.

```text
maxProfit = 0
```

### Day 2 — Price = 5

Potential profit:

```text
5 - 1 = 4
```

So:

```text
maxProfit = 4
```

### Day 3 — Price = 3

Potential profit:

```text
3 - 1 = 2
```

This is not better than `4`.

```text
maxProfit = 4
```

### Day 4 — Price = 6

Potential profit:

```text
6 - 1 = 5
```

This is better.

```text
maxProfit = 5
```

### Day 5 — Price = 4

Potential profit:

```text
4 - 1 = 3
```

No improvement.

Final answer:

```text
5
```

---

## 5. Why Does This Work?

The important observation is:

> For each selling price, the best possible buying price is simply the lowest price that appeared before it.

We don't need to remember every previous price.

We only need the **minimum price so far**.

This allows us to solve the problem in a single pass.

---

## 6. Important Ordering

When processing each price, think in this order:

1. Use the minimum price seen so far to calculate today's possible profit.
2. Update the maximum profit.
3. Update the minimum price if today's price is lower.

This ordering is important because the stock must be bought **before** it is sold.

---

## 7. Why Can't We Just Find the Minimum and Maximum?

A common mistake is:

> Find the minimum price and maximum price anywhere in the array, then subtract them.

That does **not** always work.

Example:

```text
[7, 6, 4, 3, 1]
```

The minimum is `1`, but it occurs **after** all the higher prices.

You cannot buy at `1` and sell at `7` because that would mean selling before buying.

The order of the days matters.

---

## 8. Another Important Example

Consider:

```text
prices = [7, 6, 4, 3, 1]
```

Every possible transaction loses money.

Therefore:

```text
Output = 0
```

This is why `maxProfit` should start at:

```text
0
```

---

## 9. Algorithm

Use a single loop:

```text
1. Set minimum price to the first price.
2. Set maximum profit to 0.
3. Visit each remaining price.
4. Calculate today's possible profit using the minimum price.
5. Update maximum profit.
6. Update minimum price if today's price is lower.
7. Return maximum profit.
```

---

## 10. Complexity

### Time Complexity

We scan the array only once.

```text
O(n)
```

### Space Complexity

We use only a few variables.

```text
O(1)
```

This is the optimal approach.

---

## 11. Common Mistakes

### Mistake 1: Buying after selling

Always remember:

```text
BUY → SELL
```

Never:

```text
SELL → BUY
```

### Mistake 2: Using nested loops unnecessarily

Trying every pair works, but gives:

```text
O(n²)
```

The one-pass approach is better.

### Mistake 3: Forgetting the zero-profit case

If prices continuously decrease, the answer must be:

```text
0
```

### Mistake 4: Updating the minimum price incorrectly

The minimum price should represent the lowest price seen **up to the current point**.

---

## 12. Student Challenge

Try completing `Main.java` without looking at the LeetCode solution.

For:

```text
prices = [7, 1, 5, 3, 6, 4]
```

You should get:

```text
Maximum Profit: 5
```

Then test:

```text
prices = [7, 6, 4, 3, 1]
```

Expected:

```text
Maximum Profit: 0
```

Also try:

```text
prices = [1, 2, 3, 4, 5]
```

Expected:

```text
Maximum Profit: 4
```

---

## 13. Practice Variations

After completing the basic problem, think about these variations:

1. What if you can make multiple transactions?
2. What if there is a transaction fee?
3. What if you must wait one day after selling before buying again?
4. What if you can hold only one stock at a time?

These variations lead to more advanced **Dynamic Programming** and **Greedy** problems.

---

## 14. Interview Insight

A strong interview explanation is:

> "I scan the prices once while maintaining the minimum buying price seen so far. For each current price, I calculate the profit that would result from selling today and update the maximum profit. This gives O(n) time and O(1) space."

The important concept is not just memorizing the code.

Understand **why the minimum price so far is enough**.

---

## 15. Learning Takeaway

This problem teaches an important pattern:

### Track the best previous state while scanning forward.

Instead of comparing every pair, ask:

> "What information from the past is actually necessary to make the best decision today?"

Here, that information is simply:

```text
Minimum price seen so far
```

That turns an `O(n²)` brute-force idea into an optimal:

```text
O(n) time
O(1) space
```

---

## 16. Self-Check

Before considering this problem complete, make sure you can answer:

- Why do we track the minimum price?
- Why must buying happen before selling?
- Why does finding the global minimum and maximum not always work?
- Why is `maxProfit` initialized to `0`?
- Why is the solution `O(n)`?
- Why is the extra space `O(1)`?
- Can you explain the solution without looking at the code?

If you can answer all of these, you understand the problem—not just the implementation.
