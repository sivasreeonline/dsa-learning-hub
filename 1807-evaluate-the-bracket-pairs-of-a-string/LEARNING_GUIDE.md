# 1807. Evaluate the Bracket Pairs of a String — Learning Guide

## LeetCode Tags
- Array
- Hash Table
- String

## Problem in Simple Words
Replace each parenthesized key with its value from `knowledge`. If a key is unknown, replace the entire bracket pair with `?`. Characters outside brackets stay unchanged.

Example: `(name)is(age)yearsold` with `name -> bob` and `age -> two` becomes `bobistwoyearsold`.

## Approach
1. Build a `HashMap` from the key-value pairs.
2. Scan `s` from left to right.
3. For ordinary characters, append the character.
4. When `(` is found, locate the next `)`, extract the key, and append its value or `?`.
5. Move the index to the closing bracket to avoid processing the key again.

The problem guarantees there are no nested brackets.

## Accepted Java Solution

```java
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution
{
    public String evaluate(String s, List<List<String>> knowledge)
    {
        Map<String, String> map = new HashMap<>();

        for (List<String> pair : knowledge)
        {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
            {
                int close = s.indexOf(')', i + 1);
                String key = s.substring(i + 1, close);
                result.append(map.getOrDefault(key, "?"));
                i = close;
            }
            else
            {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
```

## Complexity
Let `n` be the length of `s` and `m` the number of knowledge entries.

- **Time:** `O(n + m)` average, assuming average constant-time map operations.
- **Space:** `O(m)` for the map, plus `O(n)` for the output buffer.

## Common Mistakes
- Including parentheses in the extracted key.
- Forgetting the `?` fallback for an unknown key.
- Failing to move the index to the closing bracket.
- Using repeated immutable-string concatenation instead of `StringBuilder`.

## Pattern
**HashMap + String Traversal** — preprocess key-value pairs, then parse the string once.
