# Time complexity - O(1)
# Space complexity - O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Here stack is used to solve this problem. Stack is LIFO(Last in first out). Created two stacks in which the first stack will have the values
# The second stack will have the minimum value of the all the values till that position.
# While performing push, the minimum values is taken by comparing both the val and the minstack[-1] position.

class MinStack:

    def __init__(self):
        self.stack = []
        self.minstack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        
        val = min(val, self.minstack[-1] if self.minstack else val)
        self.minstack.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.minstack.pop()

    def top(self) -> int:
        return self.stack[-1]


    def getMin(self) -> int:
        return self.minstack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
