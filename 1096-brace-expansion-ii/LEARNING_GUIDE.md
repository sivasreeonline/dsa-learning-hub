# 1096. Brace Expansion II — Learning Guide

## LeetCode Tags
- String
- Backtracking
- Recursion
- Set

## Problem in Simple Words
An expression uses lowercase letters, braces, and commas. Commas inside braces mean **choose any one** of the alternatives. Expressions next to each other mean **concatenate** the choices.

Return every distinct resulting word in lexicographical order.

Example: `{a,b}{c,{d,e}}` produces `[ac, ad, ae, bc, bd, be]`.

## Core Idea: Expand the Innermost Braces
Find the first `}`. Its matching `{` is the last opening brace before it, making this an innermost brace pair.

1. Split the expression into a prefix, the choices inside the braces, and a suffix.
2. For each comma-separated choice, replace the brace expression with that choice.
3. Recursively expand the new expression.
4. When no `}` remains, the expression is a complete word.

## Why a TreeSet?
A `TreeSet<String>` removes duplicates automatically and stores words in sorted order. Converting it to an `ArrayList` gives the required return type.

## Accepted Java Solution

```java
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class Solution
{
    private TreeSet<String> words;

    public List<String> braceExpansionII(String expression)
    {
        words = new TreeSet<>();
        expand(expression);
        return new ArrayList<>(words);
    }

    private void expand(String expression)
    {
        int close = expression.indexOf('}');

        if (close == -1)
        {
            words.add(expression);
            return;
        }

        int open = expression.lastIndexOf('{', close);

        String prefix = expression.substring(0, open);
        String suffix = expression.substring(close + 1);
        String choices = expression.substring(open + 1, close);

        for (String choice : choices.split(","))
        {
            expand(prefix + choice + suffix);
        }
    }
}
```

## Complexity
Let `B` be the number of distinct words generated and `L` their maximum length. The number of possible words can grow exponentially with the expression, so total work and storage are output-dependent. Recursive expansions create intermediate strings, and each `TreeSet` insertion performs ordered-set comparisons.

## Common Mistakes
- Splitting on every comma in the full expression; some commas belong to nested braces.
- Expanding an outer brace before its nested braces.
- Forgetting that concatenation forms every combination of choices.
- Returning duplicates or failing to sort the final words.

## Pattern Recognition
Recursive expansion/backtracking is useful when a compact expression represents multiple possible strings. Use a set when results must be unique, and an ordered set when results must also be sorted.
