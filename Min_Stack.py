# Time Complexity: O(1)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min_stack = []

    def push(self, x: int) -> None:
        self.stack.append(x)
        if len(self.min_stack):
            min_now = self.min_stack[-1]
            self.min_stack.append(x if x < min_now else min_now)
        else:
            self.min_stack.append(x)

    def pop(self) -> None:
        if len(self.stack) is not None:
            self.stack.pop()
            self.min_stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]

# Your MinStack object will be instantiated and called as such:
minStack = MinStack()
minStack.push(-2)
minStack.push(0)
minStack.push(-3)
print("Current minimum:",minStack.getMin())   # Returns -3.
print("Popped value:", minStack.pop())
print("Top value:", minStack.top())      #Returns 0.
print("new minimum:",minStack.getMin())   # Returns -2