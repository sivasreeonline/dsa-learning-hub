# Longest Valid Parentheses — Learning Guide

## 🏷️ Tags
- String
- Dynamic Programming
- Stack
- Bracket Sequences

## 🎯 Problem
Given a string containing only `(` and `)`, return the length of the longest valid parentheses substring.

Example:
```text
s = ")()())"
answer = 4
```

## 💡 Key Idea

Use a **stack of indices**, not a stack of parentheses.

Start with:
```text
stack = [-1]
```

The `-1` acts as the boundary immediately before the string.

For `(`, push its index.

For `)`:
1. Pop the matching opening-parenthesis index.
2. If the stack becomes empty, push the current index as the new invalid boundary.
3. Otherwise, the current valid length is:
```text
i - stack.peek()
```

## 🔍 Dry Run

Input:
```text
s = ")()())"
```

| i | char | Stack after operation | Current length | Max |
|---:|:---:|:---|---:|---:|
| 0 | `)` | `[0]` | 0 | 0 |
| 1 | `(` | `[0,1]` | — | 0 |
| 2 | `)` | `[0]` | 2 | 2 |
| 3 | `(` | `[0,3]` | — | 2 |
| 4 | `)` | `[0]` | 4 | 4 |
| 5 | `)` | `[5]` | 0 | 4 |

Answer: `4`

## ✅ Accepted Java

```java
import java.util.Stack;

class Solution
{
    public int longestValidParentheses(String s)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
            {
                stack.push(i);
            }
            else
            {
                stack.pop();

                if (stack.isEmpty())
                {
                    stack.push(i);
                }
                else
                {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}
```

## 🐍 Python

```python
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stack = [-1]
        max_length = 0

        for i, ch in enumerate(s):
            if ch == '(':
                stack.append(i)
            else:
                stack.pop()

                if not stack:
                    stack.append(i)
                else:
                    max_length = max(max_length, i - stack[-1])

        return max_length
```

## 💻 C++

```cpp
class Solution
{
public:
    int longestValidParentheses(string s)
    {
        stack<int> st;
        st.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++)
        {
            if (s[i] == '(')
            {
                st.push(i);
            }
            else
            {
                st.pop();

                if (st.empty())
                {
                    st.push(i);
                }
                else
                {
                    maxLength = max(maxLength, i - st.top());
                }
            }
        }

        return maxLength;
    }
};
```

## 🌐 JavaScript

```javascript
var longestValidParentheses = function(s)
{
    const stack = [-1];
    let maxLength = 0;

    for (let i = 0; i < s.length; i++)
    {
        if (s[i] === '(')
        {
            stack.push(i);
        }
        else
        {
            stack.pop();

            if (stack.length === 0)
            {
                stack.push(i);
            }
            else
            {
                maxLength = Math.max(
                    maxLength,
                    i - stack[stack.length - 1]
                );
            }
        }
    }

    return maxLength;
};
```

## ⏱️ Complexity
- Time: `O(n)`
- Space: `O(n)`

## ⚠️ Common Mistakes
1. Storing parentheses instead of indices.
2. Forgetting the initial `-1` boundary.
3. Forgetting to push the current index when the stack becomes empty.
4. Counting matching pairs instead of finding the longest contiguous substring.

## 🔎 Pattern Recognition

When you see **parentheses + longest valid substring + matching pairs**, think:

> **Stack + indices + boundary marker**

Reusable template:
```text
stack.push(-1)

for each index:
    if opening:
        push index
    else:
        pop
        if empty:
            push current index
        else:
            length = current index - stack.peek()
```

## 📌 Post Solution

**Title:** Longest Valid Parentheses | Stack | O(n) Time & O(n) Space

**Intuition:** Store indices rather than parentheses. The stack tracks unmatched opening positions and the boundary before the current valid substring. After a match, `i - stack.peek()` gives the current valid length.

**Approach:**
1. Push `-1` as the initial boundary.
2. Push indices of `(`.
3. For `)`, pop.
4. If empty, push the current index as a new boundary.
5. Otherwise calculate `i - stack.peek()`.
6. Track the maximum.

**Complexity:** `O(n)` time and `O(n)` space.

If this explanation helped you understand the index-stack technique, **please upvote the solution!** 👍
