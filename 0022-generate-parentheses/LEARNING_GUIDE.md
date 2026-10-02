# 22. Generate Parentheses

## LeetCode Tags
- String
- Dynamic Programming
- Backtracking
- Bracket Sequences

## Post Solution Title
**Generate Parentheses | Backtracking | O(Cₙ × n) Time & O(n) Auxiliary Space**

## Intuition

Build the parentheses string one character at a time.

There are only two choices:

- Add `(`
- Add `)`

But each choice has a rule.

### Rule 1 — Add `(`
We have only `n` opening brackets:

```text
open < n
```

### Rule 2 — Add `)`
A closing bracket is valid only when there is an unmatched opening bracket:

```text
close < open
```

These two rules prevent invalid branches from being generated.

## Backtracking State

We track:

```text
open   = number of '(' already used
close  = number of ')' already used
current = parentheses string being built
```

When the string reaches length `2 * n`, it is a complete valid answer.

After exploring a choice, we remove that character. This is the **backtracking** step.

## Accepted Java Solution

```java
import java.util.ArrayList;
import java.util.List;

class Solution
{
    public List<String> generateParenthesis(int n)
    {
        List<String> result = new ArrayList<>();

        backtrack(n, 0, 0, new StringBuilder(), result);

        return result;
    }

    private void backtrack(
        int n,
        int open,
        int close,
        StringBuilder current,
        List<String> result)
    {
        if (current.length() == 2 * n)
        {
            result.add(current.toString());
            return;
        }

        if (open < n)
        {
            current.append('(');
            backtrack(n, open + 1, close, current, result);
            current.deleteCharAt(current.length() - 1);
        }

        if (close < open)
        {
            current.append(')');
            backtrack(n, open, close + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
```

## Dry Run — n = 2

Start:

```text
current = ""
open = 0
close = 0
```

Choose `(`:

```text
(
open = 1
close = 0
```

From here we have two valid possibilities.

### Branch 1

```text
((
```

Then:

```text
(()
(())
```

Result:

```text
(())
```

### Branch 2

Backtrack to:

```text
(
```

Choose `)`:

```text
()
```

Then:

```text
()(
()()
```

Result:

```text
()()
```

Final:

```text
["(())", "()()"]
```

## Why `close < open`?

Suppose we already have:

```text
())
```

The number of closing brackets is greater than the number of opening brackets.

That branch can never become valid.

So we never create it.

This is the main pruning condition:

```java
if (close < open)
```

## Why Backtrack?

Suppose we choose:

```java
current.append('(');
```

After exploring that branch, the `(` must be removed before trying another branch:

```java
current.deleteCharAt(current.length() - 1);
```

The pattern is:

```text
Choose
   ↓
Explore
   ↓
Undo
```

## Complexity

The number of valid combinations is the nth Catalan number:

```text
Cₙ = 1 / (n + 1) × C(2n, n)
```

There are `Cₙ` valid strings and every string has length `2n`.

### Time

```text
O(Cₙ × n)
```

### Auxiliary Space

```text
O(n)
```

for the recursion/current string.

The returned result itself requires:

```text
O(Cₙ × n)
```

space.

## Common Mistakes

### 1. Using `close < n`

Incorrect:

```java
if (close < n)
```

Correct:

```java
if (close < open)
```

### 2. Forgetting to undo a choice

After recursion, remove the character:

```java
current.deleteCharAt(current.length() - 1);
```

### 3. Wrong base condition

The final string contains `n` opening and `n` closing brackets:

```text
length = 2 * n
```

So:

```java
if (current.length() == 2 * n)
```

## Pattern Recognition

When a problem asks you to:

- generate all valid combinations,
- explore multiple choices,
- reject invalid partial solutions,
- and undo choices,

think:

**Backtracking + pruning**

For this problem:

```text
Backtracking
+
Parentheses balance
+
Constraint pruning
```

## Python

```python
class Solution:
    def generateParenthesis(self, n: int) -> list[str]:
        result = []

        def backtrack(open_count, close_count, current):
            if len(current) == 2 * n:
                result.append("".join(current))
                return

            if open_count < n:
                current.append("(")
                backtrack(open_count + 1, close_count, current)
                current.pop()

            if close_count < open_count:
                current.append(")")
                backtrack(open_count, close_count + 1, current)
                current.pop()

        backtrack(0, 0, [])
        return result
```

## C++

```cpp
class Solution
{
private:
    void backtrack(
        int n,
        int open,
        int close,
        string& current,
        vector<string>& result)
    {
        if (current.length() == 2 * n)
        {
            result.push_back(current);
            return;
        }

        if (open < n)
        {
            current.push_back('(');
            backtrack(n, open + 1, close, current, result);
            current.pop_back();
        }

        if (close < open)
        {
            current.push_back(')');
            backtrack(n, open, close + 1, current, result);
            current.pop_back();
        }
    }

public:
    vector<string> generateParenthesis(int n)
    {
        vector<string> result;
        string current;

        backtrack(n, 0, 0, current, result);

        return result;
    }
};
```

## JavaScript

```javascript
var generateParenthesis = function(n)
{
    const result = [];

    function backtrack(open, close, current)
    {
        if (current.length === 2 * n)
        {
            result.push(current);
            return;
        }

        if (open < n)
        {
            backtrack(open + 1, close, current + "(");
        }

        if (close < open)
        {
            backtrack(open, close + 1, current + ")");
        }
    }

    backtrack(0, 0, "");

    return result;
};
```

## Key Takeaway

Remember only these two conditions:

```text
Add '(' → open < n

Add ')' → close < open
```

Everything else is the standard backtracking pattern:

```text
Choose → Explore → Undo
```

## Upvote CTA

> 💡 If this explanation, dry run, and backtracking approach helped you understand **Generate Parentheses**, please consider giving it an upvote! Your support motivates me to create more clear, beginner-friendly solutions. ❤️
