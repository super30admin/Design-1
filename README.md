# Design-1

This document contains solutions to two design problems from LeetCode. Each solution is implemented in Java and includes a brief explanation of the approach.

## Problem 1: Design HashSet (https://leetcode.com/problems/design-hashset/)

### Approach:
We use a boolean array to simulate the behavior of a hash set. The array index represents the key, and the value at that index indicates whether the key is present in the set. This approach ensures constant time complexity for add, remove, and contains operations.

```java
class DesignHashSet {

    private boolean[] data;

    public DesignHashSet() {
        data = new boolean[1000001];
    }
    
    public void add(int key) {
        data[key] = true;
    }
    
    public void remove(int key) {
        data[key] = false;
    }
    
    public boolean contains(int key) {
        return data[key];
    }
}
```

---

## Problem 2: Design MinStack (https://leetcode.com/problems/min-stack/)

### Approach:
We use a single stack to store values and maintain the minimum value at each step. When pushing a new minimum, the previous minimum is stored below it to ensure it can be restored during a pop operation. This approach ensures constant time complexity for all operations.

```java
class MinStack {

    Stack<Integer> st;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (min >= val) {
            st.push(min);
            min = val;
        }
        st.push(val);
    }
    
    public void pop() {
        if (st.pop() == min) {
            min = st.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}
```
