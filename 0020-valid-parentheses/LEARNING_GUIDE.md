# Valid Parentheses — Learning Guide

## 🎯 What Are We Trying to Do?

You are given a string containing three types of brackets:

```text
( )
[ ]
{ }
```

Your task is to determine whether the brackets are **validly matched and correctly nested**.

A string is valid when:

1. Every opening bracket has a matching closing bracket.
2. Closing brackets appear in the correct order.
3. Brackets are properly nested.

### Example 1

```text
s = "({[]})"
```

This is valid because the brackets close in the correct order:

```text
( { [ ] } )
```

Result:

```text
true
```

### Example 2

```text
s = "([)]"
```

This is invalid.

Although the same types of brackets are present, the order is wrong:

```text
( [ ) ]
```

The `)` cannot close `(` while `[` is still open.

Result:

```text
false
```

---

## 💡 Key Idea: Use a Stack

Think about brackets like a stack of plates.

When you see an opening bracket, you put something on the top of the stack.

When you see a closing bracket, it must match the bracket expected at the **top** of the stack.

Why?

Because the **last opening bracket must be the first one to close**.

This is the **LIFO** principle:

```text
Last In → First Out
```

That makes a Stack the natural data structure for this problem.

---

## 🧠 A Useful Trick

Instead of storing the opening bracket, we can store the **closing bracket we expect**.

For example:

```text
'(' → expect ')'
'[' → expect ']'
'{' → expect '}'
```

Suppose we process:

```text
({[]})
```

After reading the opening brackets, the stack represents the closing brackets we expect:

```text
)
}
]
```

The next character is:

```text
]
```

It matches the top of the stack.

Then:

```text
}
```

matches.

Then:

```text
)
```

matches.

This makes the matching logic simple.

---

## 🔍 Step-by-Step Approach

### Step 1 — Create a Stack

Use a stack to remember the closing brackets that are expected.

In Java, we can use:

```java
Deque<Character> stack = new ArrayDeque<>();
```

---

### Step 2 — Traverse the String

Process every character from left to right.

For each character, ask:

> Is this an opening bracket or a closing bracket?

---

### Step 3 — Handle Opening Brackets

If the character is:

```text
(
[
{
```

push the corresponding closing bracket onto the stack.

For example:

```text
'(' → push ')'
'[' → push ']'
'{' → push '}'
```

---

### Step 4 — Handle Closing Brackets

If the character is a closing bracket:

```text
)
]
}
```

we need to check the top of the stack.

There are two important cases.

#### Case A — Stack is empty

If there is no opening bracket waiting to be closed, the string is invalid.

Example:

```text
")"
```

There is nothing that can match `)`.

Return:

```text
false
```

#### Case B — Top does not match

Suppose the stack expects:

```text
]
```

but we encounter:

```text
)
```

The brackets are incorrectly nested.

Return:

```text
false
```

If the closing bracket matches the top of the stack, remove that expected bracket and continue.

---

## 📝 Dry Run

Let's trace:

```text
s = "({[]})"
```

### Character 1: `(`

Opening bracket.

Push its expected closing bracket:

```text
Stack: [)]
```

### Character 2: `{`

Opening bracket.

Push:

```text
Stack: [), }]
```

The top is `}`.

### Character 3: `[` 

Opening bracket.

Push:

```text
Stack: [), }, ]]
```

The top is `]`.

### Character 4: `]`

Closing bracket.

Top of stack is:

```text
]
```

It matches.

Remove it:

```text
Stack: [), }]
```

### Character 5: `}`

Closing bracket.

Top is:

```text
}
```

It matches.

Remove it:

```text
Stack: [)]
```

### Character 6: `)`

Closing bracket.

Top is:

```text
)
```

It matches.

Remove it:

```text
Stack: []
```

The stack is empty.

Therefore:

```text
true
```

---

## 🔎 Understanding the Invalid Case

Consider:

```text
s = "([)]"
```

Process:

```text
(
```

Expected:

```text
)
```

Then:

```text
[
```

Expected:

```text
]
```

Now the stack expects:

```text
]
```

But the next character is:

```text
)
```

This does **not** match the top of the stack.

Therefore:

```text
false
```

This is why a simple count of brackets is not enough.

The **order** matters.

---

## ⚡ Why Can't We Just Count the Brackets?

Consider:

```text
"([)]"
```

There is:

```text
1 '('
1 ')'
1 '['
1 ']'
```

The counts are equal.

But the string is still invalid.

The problem is not just about matching counts.

It is about **correct nesting and order**.

That is exactly what the Stack helps us track.

---

## ⏱️ Complexity

### Time Complexity

We visit every character once.

Therefore:

```text
O(n)
```

where `n` is the length of the string.

### Space Complexity

In the worst case, all characters can be opening brackets and therefore stored in the stack.

Therefore:

```text
O(n)
```

---

## 🚫 Common Mistakes

### 1. Checking only whether the counts are equal

Equal numbers of opening and closing brackets do not guarantee validity.

Example:

```text
([)]
```

is invalid.

---

### 2. Ignoring the order

The most recently opened bracket must be the first one to close.

This is the key Stack principle:

```text
LIFO
```

---

### 3. Forgetting the empty-stack case

If a closing bracket appears when the stack is empty, there is nothing to match it.

The string is invalid.

---

### 4. Forgetting the final stack check

Even if every closing bracket matched, there could still be unmatched opening brackets.

Example:

```text
"((("
```

No closing brackets were found.

The stack is not empty.

Therefore the answer is:

```text
false
```

---

## 🧩 Student Challenge

Before looking at the completed solution, finish the TODOs in `Main.java`.

Try to answer these questions:

1. What should be pushed when you see `(`?
2. What should be pushed when you see `[`?
3. What should be pushed when you see `{`?
4. What should happen when the stack is empty and you see a closing bracket?
5. What should happen when the closing bracket does not match the top of the stack?
6. What should the final stack state be for a valid string?

Then run:

```bash
javac Main.java
java Main
```

For the starter input:

```text
({[]})
```

the completed program should produce:

```text
Input: ({[]})
Valid: true
```

---

## 🔁 Practice Variations

After solving the starter example, change the input in `Main.java`.

### Variation 1

```java
String s = "()";
```

Expected:

```text
true
```

### Variation 2

```java
String s = "()[]{}";
```

Expected:

```text
true
```

### Variation 3

```java
String s = "(]";
```

Expected:

```text
false
```

### Variation 4

```java
String s = "([)]";
```

Expected:

```text
false
```

### Variation 5

```java
String s = "{[]}";
```

Expected:

```text
true
```

### Variation 6

```java
String s = "(((";
```

Expected:

```text
false
```

Try creating your own examples as well.

---

## 🎓 Learning Takeaway

The most important lesson from this problem is not simply:

> Use a Stack.

The deeper pattern is:

> When the most recently opened item must be handled first, think about the Stack data structure.

For brackets:

```text
Last opening bracket
        ↓
Must close first
        ↓
        Stack
```

The problem teaches an important **LIFO** pattern that appears in many other problems involving:

- Parentheses matching
- Expression evaluation
- Undo operations
- Function-call processing
- Backtracking
- Monotonic stack problems

---

## 🧠 Interview Tip

If an interviewer asks:

> "Why did you choose a Stack?"

A strong answer is:

> "Because brackets must be closed in the reverse order in which they were opened. That is exactly the Last-In-First-Out behavior provided by a stack."

That explanation shows that you understand **why** the data structure fits the problem, rather than simply memorizing a solution.

---

## ✅ Before You Move On

Make sure you can explain these three things without looking at the solution:

- **Why is a Stack suitable for bracket matching?**
- **Why is `([)]` invalid even though all brackets are present?**
- **Why must the stack be empty at the end for the string to be valid?**

If you can explain those clearly, you understand the core idea behind **Valid Parentheses**.
