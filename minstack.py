# Approach:
# 1. We maintain two stacks: `stack` for storing elements and `minStack` to keep track of the minimum element at each level.
# 2. On `push()`, we store the element in `stack` and push the **minimum of the current value and the previous min** into `minStack`.
# 3. `pop()` removes elements from both stacks, while `top()` and `getMin()` retrieve values in **O(1) time**.

# Time Complexity: push(), pop(), top(), getMin() -> O(1)
# Space Complexity: O(n)

class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        val = min(val, self.minStack[-1] if self.minStack else val)
        self.minStack.append(val)
             
    def pop(self) -> None:
        self.minStack.pop()
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]
        
    def getMin(self) -> int:
        return self.minStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
