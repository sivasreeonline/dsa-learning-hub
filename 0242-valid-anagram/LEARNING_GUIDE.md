# Valid Anagram — Learning Guide

## 1. What Is the Problem?

You are given two strings `s` and `t`.

Determine whether `t` is an **anagram** of `s`.

Two strings are anagrams when they contain:

- the same characters
- with the same frequencies
- regardless of their order

### Example

```text
s = "anagram"
t = "nagaram"
```

Both strings contain:

```text
a → 3
n → 2
g → 1
r → 1
m → 1
```

Therefore:

```text
Output: true
```

---

## 2. Another Example

```text
s = "rat"
t = "car"
```

Character frequencies are different because `t` contains `c` while `s` contains `t`.

Therefore:

```text
Output: false
```

---

## 3. The Important Question

Do not think:

> "Are the characters in the same positions?"

Instead ask:

> **"Do both strings contain exactly the same characters with exactly the same frequencies?"**

For example:

```text
"listen"
"silent"
```

The order is different, but the character frequencies are identical.

Therefore they are anagrams.

---

## 4. Straightforward Approach — Sorting

One possible solution is:

1. Convert both strings to character arrays.
2. Sort both arrays.
3. Compare them.

For example:

```text
listen
silent
```

After sorting:

```text
eilnst
eilnst
```

They are equal.

This approach works, but sorting introduces:

```text
O(n log n)
```

time complexity.

Can we do better?

Yes.

---

## 5. Key Idea — Frequency Counting

Instead of sorting, count how many times every character appears.

A `HashMap` is perfect for this.

We can store:

```text
character → frequency
```

For:

```text
s = "anagram"
```

the map becomes:

```text
a → 3
n → 2
g → 1
r → 1
m → 1
```

Now process the second string and reduce those frequencies.

---

## 6. Why HashMap?

A `HashMap` allows us to associate one piece of information with another.

Here:

```text
Key   = character
Value = frequency
```

For example:

```java
HashMap<Character, Integer> frequency = new HashMap<>();
```

We can update a count using:

```java
frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
```

This means:

> Get the current frequency, or use `0` if the character hasn't appeared yet, then add `1`.

---

## 7. Dry Run

Consider:

```text
s = "anagram"
t = "nagaram"
```

### Step 1 — Count `s`

Process:

```text
 a n a g r a m
```

The map becomes:

```text
a → 3
n → 1
g → 1
r → 1
m → 1
```

### Step 2 — Process `t`

Now process:

```text
n a g a r a m
```

For `n`, decrease its count from `1` to `0` and remove it.

For `a`, decrease its count from `3` to `2`.

Continue the same process.

Eventually every frequency reaches zero and the map becomes:

```text
{}
```

Therefore:

```text
true
```

---

## 8. Why Check String Length First?

If two strings have different lengths, they cannot possibly contain the same characters with the same frequencies.

For example:

```text
"abc"
"abcc"
```

There is no need to build the map.

We can immediately return:

```text
false
```

This is an example of **early validation**.

---

## 9. Algorithm

```text
1. If s.length() != t.length(), return false.
2. Create a HashMap<Character, Integer>.
3. Traverse s.
4. Count the frequency of every character.
5. Traverse t.
6. For each character:
   a. If it does not exist in the map, return false.
   b. Decrease its frequency.
   c. Remove it if its frequency becomes zero.
7. If the map is empty, return true.
```

---

## 10. Why Do We Remove Characters?

Suppose:

```text
s = "aab"
```

The frequency map starts as:

```text
a → 2
b → 1
```

After processing both `a` characters:

```text
b → 1
```

After processing `b`:

```text
{}
```

An empty map tells us:

> Every required character has been matched exactly.

---

## 11. Important Difference: HashSet vs HashMap

This problem connects directly to **Contains Duplicate**.

### Contains Duplicate

We only needed to know:

> Have I seen this value?

So `HashSet` was enough.

### Valid Anagram

We need to know:

> How many times have I seen this character?

So we need `HashMap`.

The pattern is:

```text
Need existence?
→ HashSet

Need frequency/count?
→ HashMap
```

---

## 12. Complexity

Let `n` be the length of the strings.

### Time Complexity

We traverse the strings a constant number of times.

```text
O(n)
```

### Space Complexity

The map stores the distinct characters.

```text
O(k)
```

where `k` is the number of distinct characters.

For a fixed character set such as lowercase English letters, `k` is bounded by a constant, but the general HashMap analysis is `O(k)`.

---

## 13. Common Mistakes

### Mistake 1: Comparing characters by position

This is wrong:

```text
"anagram"
"nagaram"
```

The positions are different, but the frequencies are the same.

### Mistake 2: Forgetting frequency

A simple set is not enough.

For example:

```text
s = "aab"
t = "abb"
```

Both contain `a` and `b`, but their frequencies differ.

### Mistake 3: Forgetting the length check

Different lengths immediately mean:

```text
false
```

### Mistake 4: Not handling a missing character

If `t` contains a character that never appeared in `s`, the strings cannot be anagrams.

Return:

```text
false
```

---

## 14. Student Challenge

Complete the TODOs in `Main.java`.

### Test 1

```text
s = "anagram"
t = "nagaram"
```

Expected:

```text
true
```

### Test 2

```text
s = "rat"
t = "car"
```

Expected:

```text
false
```

### Test 3

```text
s = "listen"
t = "silent"
```

Expected:

```text
true
```

### Test 4

```text
s = "aab"
t = "abb"
```

Expected:

```text
false
```

### Test 5

```text
s = ""
t = ""
```

Expected:

```text
true
```

---

## 15. Practice Variations

After understanding this problem, try:

1. Group Anagrams.
2. Find the first character that appears only once.
3. Count character frequencies in a string.
4. Find the most frequent character.
5. Determine whether two strings have the same character frequency.
6. Find all characters that appear in both strings.

These problems build the same frequency-counting skill.

---

## 16. Interview Explanation

A concise interview explanation:

> "I first check whether the strings have the same length. Then I use a HashMap to count the frequency of each character in the first string. While traversing the second string, I decrease the corresponding frequency. If a character is missing or cannot be matched, I return false. If all frequencies are consumed, the strings are anagrams. The solution takes O(n) time and O(k) space."

---

## 17. A Useful Java Method

You will see this frequently in Java DSA:

```java
map.getOrDefault(key, 0)
```

For example:

```java
frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
```

If `ch` is not in the map:

```text
getOrDefault → 0
```

Then:

```text
0 + 1 = 1
```

If it already has frequency `3`:

```text
3 + 1 = 4
```

This is extremely useful for frequency-counting problems.

---

## 18. Learning Takeaway

The main pattern is:

# Frequency Counting

Whenever a problem asks about:

- how many times something appears
- whether two collections contain the same frequencies
- most/least frequent elements
- duplicate counts
- character frequencies

think:

```text
HashMap
    ↓
value → frequency
```

The bigger DSA pattern is:

```text
Question about EXISTENCE
        ↓
     HashSet

Question about FREQUENCY
        ↓
     HashMap
```

---

## 19. Self-Check

Before moving to the next problem, make sure you can answer:

- What makes two strings anagrams?
- Why is sorting not necessary?
- Why do we use a HashMap?
- What does the key represent?
- What does the value represent?
- Why do we check the string lengths first?
- What does `getOrDefault()` do?
- Why can we return false when a character is missing?
- Why does an empty map mean all characters matched?
- What is the time complexity?
- What is the space complexity?
- When would you use HashSet instead of HashMap?

If you can answer these and implement the TODOs yourself, you have learned the **Frequency Counting pattern**, not just LeetCode 242.
