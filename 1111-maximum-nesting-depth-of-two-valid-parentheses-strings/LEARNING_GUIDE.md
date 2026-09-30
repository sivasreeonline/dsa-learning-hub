# 1111. Maximum Nesting Depth of Two Valid Parentheses Strings

## LeetCode Tags
- String
- Stack
- Greedy

## Problem in Simple Words
Split a valid parentheses string into two subsequences, A and B. Both must remain valid parentheses strings, while minimizing the larger of their two nesting depths.

The answer array uses `0` for A and `1` for B. Multiple valid answers may exist.

## Key Idea: Alternate by Nesting Depth
Use the current nesting depth to decide the group.

- Opening `(`: assign it using the current depth parity, then increase depth.
- Closing `)`: decrease depth first, then assign it using the new depth parity.

So the rule is simply:

`group = depth % 2`

This distributes alternating nesting levels between the two groups.

## Accepted Java Solution

```java
class Solution
{
    public int[] maxDepthAfterSplit(String seq)
    {
        int[] answer = new int[seq.length()];
        int depth = 0;

        for (int i = 0; i < seq.length(); i++)
        {
            if (seq.charAt(i) == '(')
            {
                answer[i] = depth % 2;
                depth++;
            }
            else
            {
                depth--;
                answer[i] = depth % 2;
            }
        }

        return answer;
    }
}
```

## Dry Run

Input: `seq = "(()())"`

| i | char | Depth before | Action | Depth after | Group |
|---:|:---:|---:|---|---:|---:|
| 0 | `(` | 0 | assign 0, then open | 1 | 0 |
| 1 | `(` | 1 | assign 1, then open | 2 | 1 |
| 2 | `)` | 2 | close, then assign 1 | 1 | 1 |
| 3 | `(` | 1 | assign 1, then open | 2 | 1 |
| 4 | `)` | 2 | close, then assign 1 | 1 | 1 |
| 5 | `)` | 1 | close, then assign 0 | 0 | 0 |

Result:

`[0, 1, 1, 1, 1, 0]`

## Python

```python
class Solution:
    def maxDepthAfterSplit(self, seq):
        answer = [0] * len(seq)
        depth = 0

        for i, ch in enumerate(seq):
            if ch == '(':
                answer[i] = depth % 2
                depth += 1
            else:
                depth -= 1
                answer[i] = depth % 2

        return answer
```

## C++

```cpp
class Solution
{
public:
    vector<int> maxDepthAfterSplit(string seq)
    {
        vector<int> answer(seq.size());
        int depth = 0;

        for (int i = 0; i < seq.size(); i++)
        {
            if (seq[i] == '(')
            {
                answer[i] = depth % 2;
                depth++;
            }
            else
            {
                depth--;
                answer[i] = depth % 2;
            }
        }

        return answer;
    }
};
```

## JavaScript

```javascript
var maxDepthAfterSplit = function(seq)
{
    const answer = new Array(seq.length);
    let depth = 0;

    for (let i = 0; i < seq.length; i++)
    {
        if (seq[i] === '(')
        {
            answer[i] = depth % 2;
            depth++;
        }
        else
        {
            depth--;
            answer[i] = depth % 2;
        }
    }

    return answer;
};
```

## Complexity
- **Time:** `O(n)`
- **Auxiliary space:** `O(1)` excluding the required answer array
- **Output space:** `O(n)`

## Common Mistakes
- Assigning groups randomly.
- For `)`, assigning the group before decreasing depth.
- Building the two strings when only the assignment array is needed.
- Assuming the output must exactly match the sample; multiple answers can be valid.

## Pattern Recognition
**Greedy + Parentheses Depth + Parity**

When nested parentheses must be divided between two groups, alternate groups according to the nesting depth:

`depth % 2`

## Upvote CTA

> 💡 If this explanation, dry run, and multi-language implementation helped you understand the depth-parity trick, please consider giving it an upvote! Your support motivates me to create more clear, beginner-friendly solutions. ❤️
