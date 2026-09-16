# Valid Palindrome — Learning Guide

## 1. What is the Problem?

You are given a string `s`. Determine whether it is a palindrome after:

- Converting uppercase letters to lowercase.
- Ignoring all characters that are not letters or digits.

A palindrome reads the same forward and backward.

### Example 1

```text
Input:  "A man, a plan, a canal: Panama"
Output: true
```

After ignoring spaces and punctuation and converting to lowercase:

```text
amanaplanacanalpanama
```

It reads the same from both directions.

### Example 2

```text
Input:  "race a car"
Output: false
```

---

## 2. The First Thought

One possible solution is:

1. Remove spaces and punctuation.
2. Convert the string to lowercase.
3. Reverse the resulting string.
4. Compare the original cleaned string with the reversed string.

This works, but it requires creating another string.

Can we solve it without creating an additional string?

Yes!

This is where the **Two Pointers** technique helps.

---

## 3. The Key Idea — Two Pointers

Use two pointers:

```text
left  → starts from the beginning
right → starts from the end
```

Then compare characters moving toward the center.

Conceptually:

```text
A  m  a  n  a  ...
↑                    ↑
left                right
```

If the characters match:

```text
left++
right--
```

If they don't match:

```text
return false
```

If all characters match:

```text
return true
```

---

## 4. What About Spaces and Punctuation?

The problem tells us to ignore characters that are not letters or digits.

For example:

```text
"A man, a plan, a canal: Panama"
```

We should ignore:

```text
spaces
,
:
```

So before comparing characters, we move the pointers past invalid characters.

Java provides:

```java
Character.isLetterOrDigit(ch)
```

This tells us whether a character is a letter or a digit.

---

## 5. Why Do We Ignore Case?

Consider:

```text
"A"
"a"
```

They should be treated as the same character.

Java provides:

```java
Character.toLowerCase(ch)
```

So we compare the lowercase versions of the characters.

---

## 6. Dry Run

Consider:

```text
s = "A man, a plan, a canal: Panama"
```

We compare characters from both ends.

### Step 1

```text
A ---------------- a
↑                    ↑
left                right
```

Ignoring case:

```text
a == a
```

Match.

Move both pointers inward.

### Step 2

The pointers continue until they encounter matching valid characters such as:

```text
m ---------------- m
```

Match.

### Step 3

They continue comparing corresponding characters from both sides.

If every pair matches, eventually:

```text
left >= right
```

No mismatch was found.

Therefore:

```text
true
```

---

## 7. Why Two Pointers?

The important observation is:

> A palindrome only requires comparing corresponding characters from the two ends.

We don't need to build a reversed copy.

Instead:

```text
left  →→→
←←← right
```

The two pointers move toward each other.

This is a very common interview pattern.

---

## 8. Algorithm

```text
1. Set left = 0.
2. Set right = s.length() - 1.
3. While left < right:
   a. Skip non-alphanumeric characters from the left.
   b. Skip non-alphanumeric characters from the right.
   c. Compare the two characters ignoring case.
   d. If they are different, return false.
   e. Move left forward.
   f. Move right backward.
4. If the loop finishes, return true.
```

---

## 9. Complexity

### Time Complexity

Each character is processed at most a constant number of times.

```text
O(n)
```

### Space Complexity

We only use two pointers and a few variables.

No additional string or array is created.

```text
O(1)
```

This is the optimal approach for extra space.

---

## 10. Why Not Reverse the String?

A reverse-string solution can require:

```text
O(n)
```

additional space because we need another representation of the string.

The two-pointer solution avoids that.

Therefore:

```text
Two Pointers
O(n) time
O(1) extra space
```

---

## 11. Common Mistakes

### Mistake 1: Comparing every character directly

This fails when the string contains spaces or punctuation.

Example:

```text
"A man, a plan..."
```

The spaces and punctuation must be ignored.

### Mistake 2: Forgetting case-insensitive comparison

```text
'A' != 'a'
```

in a direct Java character comparison.

We need to normalize the case.

### Mistake 3: Moving only one pointer

After successfully comparing a pair, both pointers need to move:

```text
left++;
right--;
```

### Mistake 4: Forgetting the pointer boundary

Pointer movement should respect the condition that the pointers have not crossed.

---

## 12. Student Challenge

Complete the TODOs in `Main.java`.

First test:

```text
A man, a plan, a canal: Panama
```

Expected:

```text
Is Palindrome: true
```

Then test:

```text
race a car
```

Expected:

```text
Is Palindrome: false
```

Try this too:

```text
.
```

Expected:

```text
Is Palindrome: true
```

And:

```text
0P
```

Expected:

```text
Is Palindrome: false
```

---

## 13. Practice Variations

After understanding this problem, try thinking about:

1. Check whether an integer is a palindrome.
2. Reverse a character array using two pointers.
3. Find whether two numbers in a sorted array add to a target.
4. Remove duplicates from a sorted array.
5. Check whether a string can become a palindrome after deleting at most one character.

These problems strengthen the Two Pointers pattern.

---

## 14. Interview Explanation

A concise interview explanation could be:

> "I use two pointers, one from each end of the string. I skip non-alphanumeric characters, compare the remaining characters ignoring case, and move both pointers toward the center. If any pair differs, the string is not a palindrome. Otherwise, it is a palindrome. This takes O(n) time and O(1) extra space."

---

## 15. Learning Takeaway

The main lesson is the **Two Pointers pattern**.

When a problem involves:

- comparing both ends,
- reversing,
- searching from opposite directions,
- sorted arrays,
- or working toward the center,

ask yourself:

> "Can I solve this using two pointers?"

For this problem:

```text
left  →→→
←←← right
```

That simple idea eliminates the need for an additional reversed string.

---

## 16. Self-Check

Before moving to the next problem, make sure you can answer:

- What is a palindrome?
- Why do we need two pointers?
- Why do we skip non-alphanumeric characters?
- Why do we ignore case?
- Why can we use O(1) extra space?
- When should we return `false`?
- When should we return `true`?
- What other problems can use Two Pointers?

If you can explain these without looking at the guide, you have learned the pattern—not just the solution.
