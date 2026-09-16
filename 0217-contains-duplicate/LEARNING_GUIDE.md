# Contains Duplicate — Learning Guide

## 1. What is the Problem?

You are given an integer array `nums`.

Determine whether any value appears **at least twice** in the array.

Return `true` if a duplicate exists; otherwise return `false`.

### Example 1

```text
Input:  [1, 2, 3, 1]
Output: true
```

The number `1` appears twice.

### Example 2

```text
Input:  [1, 2, 3, 4]
Output: false
```

Every number appears only once.

---

## 2. The Straightforward Approach

One simple approach is to compare every number with every other number.

For `n` elements, this can require many comparisons and has:

```text
O(n²)
```

time complexity.

Can we do better?

Yes. We only need to answer one question for every number:

> Have I seen this number before?

---

## 3. The Key Idea — HashSet

A `HashSet` stores unique values and lets us efficiently check whether a value already exists.

```java
HashSet<Integer> set = new HashSet<>();
```

For each number:

```text
Already in set?
    YES → duplicate found → return true
    NO  → add it to the set
```

---

## 4. Why HashSet?

The important operation is:

```java
set.contains(number)
```

It answers:

> "Have I already seen this number?"

`HashSet` lookup and insertion are **O(1) average time**.

---

## 5. Dry Run

Consider:

```text
nums = [1, 2, 3, 1]
```

Start:

```text
set = {}
```

### Step 1 — 1

`1` is not present.

Add it:

```text
set = {1}
```

### Step 2 — 2

`2` is not present.

```text
set = {1, 2}
```

### Step 3 — 3

`3` is not present.

```text
set = {1, 2, 3}
```

### Step 4 — 1

`1` is already present.

Therefore:

```text
return true
```

We can stop immediately.

---

## 6. The General Hashing Pattern

This problem teaches the **Seen Elements** pattern:

```text
Read value
    ↓
Have I seen it before?
    ↓
 YES → Found duplicate
    ↓
 NO
    ↓
Remember it
```

This pattern appears frequently in interview problems.

---

## 7. Why Return Immediately?

Once one duplicate is found, the answer is already `true`.

For example:

```text
[1, 2, 3, 1, 5, 7, 9]
```

After finding the second `1`, there is no need to process the remaining elements.

This is called **early termination**.

---

## 8. Algorithm

```text
1. Create an empty HashSet.
2. Traverse the array.
3. For each number:
   a. Check whether it is already in the set.
   b. If yes, return true.
   c. Otherwise, add it to the set.
4. If the loop finishes, return false.
```

---

## 9. Complexity

### Time Complexity

Each element is processed once, with average O(1) HashSet lookup/insertion:

```text
O(n)
```

### Space Complexity

In the worst case, all `n` values are unique and stored in the set:

```text
O(n)
```

---

## 10. HashSet vs HashMap

This problem reinforces an important Java concept.

### HashSet

Use it when you mainly care about:

```text
"Does this value exist?"
```

Example:

```text
Have I seen 7?
```

### HashMap

Use it when you need a relationship:

```text
key → value
```

For example, in Two Sum:

```text
number → index
```

So:

```text
Two Sum
→ HashMap
→ number → index

Contains Duplicate
→ HashSet
→ value existence
```

---

## 11. Common Mistakes

### Mistake 1: Using nested loops unnecessarily

A nested-loop solution works but takes:

```text
O(n²)
```

The HashSet approach reduces this to average:

```text
O(n)
```

### Mistake 2: Forgetting to add new values

If a value is not already present, it must be remembered:

```java
set.add(number);
```

### Mistake 3: Continuing after finding a duplicate

Once a duplicate is found:

```java
return true;
```

### Mistake 4: Confusing HashSet and HashMap

Remember:

```text
HashSet → unique values / existence
HashMap → key-value relationship
```

---

## 12. Student Challenge

Complete the TODOs in `Main.java`.

### Test 1

```text
nums = [1, 2, 3, 1]
```

Expected:

```text
Contains Duplicate: true
```

### Test 2

```text
nums = [1, 2, 3, 4]
```

Expected:

```text
Contains Duplicate: false
```

### Test 3

```text
nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
```

Expected:

```text
true
```

### Test 4

```text
nums = [5]
```

Expected:

```text
false
```

---

## 13. Practice Variations

After understanding this problem, try:

1. Find the first duplicate in an array.
2. Find all duplicate values.
3. Find the first unique element.
4. Count the frequency of every number.
5. Check whether two arrays contain the same elements.
6. Find the intersection of two arrays.

These strengthen your understanding of hashing.

---

## 14. Interview Explanation

A concise interview explanation is:

> "I use a HashSet to keep track of the elements I have already seen. While traversing the array, if the current element is already in the set, I immediately return true. Otherwise, I add it to the set. If the traversal finishes without finding a duplicate, I return false. This takes O(n) average time and O(n) space."

---

## 15. Learning Takeaway

The main lesson is:

> When you need to quickly determine whether a value has appeared before, think about a HashSet.

The pattern is:

```text
Seen before?
   ↓
YES → Found what we need
NO  → Remember it
```

This simple pattern appears in many interview problems.

---

## 16. Self-Check

Before moving to the next problem, make sure you can answer:

- Why does the brute-force approach take O(n²)?
- Why is HashSet useful here?
- What does `contains()` do?
- Why do we add each new number to the set?
- Why can we return immediately when a duplicate is found?
- Why is the space complexity O(n)?
- When should you use HashSet instead of HashMap?
- What is early termination?

If you can answer these questions and implement the solution yourself, you understand the **HashSet / Seen-Elements pattern**, not just this particular problem.
