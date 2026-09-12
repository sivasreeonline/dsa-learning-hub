# Two Sum — Learning Guide

## 🎯 What Are We Trying to Do?

You are given an array of integers `nums` and an integer `target`.

Find **two different elements** whose values add up to the target, and return their **indices**.

### Example

```text
nums = [2, 7, 11, 15]
target = 9
```

Since `2 + 7 = 9`, the answer is:

```text
[0, 1]
```

---

## 💡 Key Idea: The Complement

For every number, ask:

> What number do I need to reach the target?

That number is called the **complement**.

```text
complement = target - current number
```

For example:

```text
target = 9
current number = 2

complement = 9 - 2 = 7
```

So while processing `2`, we look for `7`.

---

## 🧠 Why Use a HashMap?

A brute-force solution compares every possible pair and takes `O(n²)` time.

Instead, we remember the numbers we have already seen using a `HashMap`.

The map stores:

```text
number → index
```

For example:

```text
2 → 0
7 → 1
```

This lets us check whether a required complement has already appeared.

---

## 🔍 Step-by-Step Approach

1. Create a `HashMap` to store each number and its index.
2. Traverse the array from left to right.
3. Calculate:
   ```text
   complement = target - nums[i]
   ```
4. Check whether the complement already exists in the map.
5. If it exists, return its stored index and the current index.
6. Otherwise, store the current number and its index.
7. Continue until the pair is found.

---

## 📝 Dry Run

Input:

```text
nums = [2, 7, 11, 15]
target = 9
```

### Step 1

Current number = `2`

```text
complement = 9 - 2 = 7
```

`7` is not in the map.

Store:

```text
2 → 0
```

Map:

```text
{2=0}
```

### Step 2

Current number = `7`

```text
complement = 9 - 7 = 2
```

`2` is already in the map.

Its index is `0`, and the current index is `1`.

Therefore:

```text
answer = [0, 1]
```

---

## ⚡ Why Check Before Storing?

For every number, we:

```text
1. Calculate the complement
2. Check the map
3. Store the current number
```

This helps ensure that the two indices represent two different elements.

---

## ⏱️ Complexity

**Time:** `O(n)` — one traversal of the array with average `O(1)` HashMap lookup/insertion.

**Space:** `O(n)` — the map may contain up to `n` elements.

---

## 🚫 Common Mistakes

### Mistake 1: Returning values instead of indices

The problem asks for indices.

For `[2, 7, 11, 15]`, return:

```text
[0, 1]
```

not:

```text
[2, 7]
```

### Mistake 2: Using the same element twice

Check the map **before** storing the current element.

### Mistake 3: Forgetting what the map stores

We need:

```text
number → index
```

not just a collection of numbers.

---

## 🧩 Student Challenge

Before looking at the completed solution, finish the TODOs in `Main.java`.

Ask yourself:

1. How do I calculate the complement?
2. How do I check whether the complement exists?
3. Which two indices should I return?
4. What should I store in the map?

Then run:

```bash
javac Main.java
java Main
```

Expected output:

```text
Answer: [0, 1]
```

---

## 🔁 Practice Variations

### Variation 1

```java
int[] nums = {3, 2, 4};
int target = 6;
```

Expected:

```text
[1, 2]
```

### Variation 2

```java
int[] nums = {3, 3};
int target = 6;
```

Expected:

```text
[0, 1]
```

Then create your own test case.

---

## 🎓 Learning Takeaway

The important pattern is not simply **"use a HashMap."**

The deeper idea is:

> When looking for a pair that satisfies a condition, think about what partner the current element needs and whether that partner has already been seen.

For Two Sum:

```text
target - current number = required partner
```

The HashMap helps us remember previously seen numbers and find that partner efficiently.

This **complement + HashMap** pattern appears frequently in array and lookup problems.

---

## ✅ Before You Move On

Make sure you can explain:

- What is a complement?
- Why does a HashMap help?
- Why is the solution `O(n)` time?

If you can explain these without looking at the solution, you have learned the core idea rather than simply memorizing the code.
