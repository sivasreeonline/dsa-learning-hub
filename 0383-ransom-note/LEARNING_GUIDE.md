# Ransom Note — Learning Guide

## 1. What Is the Problem?

Given two strings, `ransomNote` and `magazine`, determine whether the ransom note can be constructed using characters from the magazine.

Each character from the magazine can be used only once.

Return `true` if it can be constructed; otherwise return `false`.

### Example

```text
ransomNote = "aa"
magazine   = "aab"

Output: true
```

There are two `a` characters available, so both required `a` characters can be used.

---

## 2. The Key Question

Think:

> Does the magazine contain enough copies of every character required by the ransom note?

This makes the problem a **frequency counting** problem.

---

## 3. Connection to Valid Anagram

In Valid Anagram, we asked whether two strings have exactly the same character frequencies.

Here, we ask whether one string has **at least enough** characters to construct another.

The underlying pattern is:

```text
Character
    ↓
Count frequency
    ↓
Consume / compare
```

---

## 4. Why Use a Frequency Array?

The problem contains only lowercase English letters.

There are exactly:

```text
26 letters
```

So instead of a HashMap, we can use:

```java
int[] frequency = new int[26];
```

This gives constant extra space.

---

## 5. Character-to-Index Mapping

The expression:

```java
ch - 'a'
```

maps a lowercase letter to an array index.

```text
'a' - 'a' = 0
'b' - 'a' = 1
'c' - 'a' = 2
...
'z' - 'a' = 25
```

For example:

```text
ch = 'c'

'c' - 'a' = 2
```

So `frequency[2]` stores the count of `c`.

---

## 6. Step 1 — Count the Magazine

Suppose:

```text
magazine = "aab"
```

After counting:

```text
a → 2
b → 1
```

The frequency array now represents the characters we have available.

---

## 7. Step 2 — Consume the Ransom Note

Suppose:

```text
ransomNote = "aa"
```

We consume the first `a`:

```text
a → 2 → 1
```

Then the second:

```text
a → 1 → 0
```

Everything required was available.

Therefore:

```text
true
```

---

## 8. What If There Aren't Enough Characters?

Consider:

```text
ransomNote = "aa"
magazine = "ab"
```

Available:

```text
a → 1
b → 1
```

First `a`:

```text
a → 1 → 0
```

Second `a`:

```text
a → 0 → -1
```

A negative count means we needed more `a` characters than the magazine contained.

Therefore:

```text
false
```

---

## 9. Algorithm

```text
1. If ransomNote.length() > magazine.length(), return false.
2. Create int[26].
3. Count every character in magazine.
4. Traverse ransomNote.
5. Decrease the frequency of each required character.
6. If any frequency becomes negative, return false.
7. Return true.
```

---

## 10. Complexity

Let:

```text
n = ransomNote.length()
m = magazine.length()
```

### Time

We scan both strings once:

```text
O(n + m)
```

### Space

The frequency array always has 26 positions:

```text
O(1)
```

---

## 11. HashMap vs Frequency Array

Use a **HashMap** when keys can be arbitrary or the character/value range is not fixed.

Use a **frequency array** when the possible values have a small known range.

Here:

```text
'a' ... 'z'
```

so:

```text
int[26]
```

is a natural choice.

---

## 12. Common Mistakes

### Mistake 1: Checking only whether a character exists

This is not enough.

```text
ransomNote = "aab"
magazine = "ab"
```

Both `a` and `b` exist, but there is only one `a`.

We need frequencies.

### Mistake 2: Reusing a magazine character

Each occurrence can be consumed only once.

### Mistake 3: Forgetting `ch - 'a'`

The array needs an index from `0` to `25`.

### Mistake 4: Continuing after a negative count

If a frequency becomes negative, immediately return `false`.

---

## 13. Student Challenge

Complete the TODOs in `Main.java`.

### Test 1

```text
ransomNote = "a"
magazine = "b"
```

Expected:

```text
false
```

### Test 2

```text
ransomNote = "aa"
magazine = "aab"
```

Expected:

```text
true
```

### Test 3

```text
ransomNote = "aa"
magazine = "ab"
```

Expected:

```text
false
```

### Test 4

```text
ransomNote = "hello"
magazine = "helloworld"
```

Expected:

```text
true
```

---

## 14. Interview Explanation

> "Because the input contains only lowercase English letters, I use an integer array of size 26 to count the characters available in the magazine. I then traverse the ransom note and consume one occurrence of each required character. If a count becomes negative, the magazine does not contain enough copies, so I return false. Otherwise I return true. The solution takes O(n + m) time and O(1) extra space."

---

## 15. Learning Takeaway

The main pattern is:

# Count → Consume

Think:

```text
What do I have?
      ↓
    COUNT

What do I need?
      ↓
   CONSUME

Did I run out?
   ↓       ↓
  YES      NO
   ↓        ↓
 false    continue
```

This pattern appears frequently in string and array problems.

---

## 16. Self-Check

Before moving on, make sure you can answer:

- Why is this a frequency-counting problem?
- Why can we use `int[26]`?
- What does `ch - 'a'` do?
- Why do we count the magazine first?
- Why do we decrease counts for the ransom note?
- What does a negative count mean?
- Why is the space complexity O(1)?
- When would you use a HashMap instead?
- How is this different from Valid Anagram?

If you can answer these and complete the TODOs yourself, you understand the **Count → Consume** pattern.
