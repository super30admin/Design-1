# Problem 2 - Min Stack (https://leetcode.com/problems/min-stack/)
# Maintain two stacks - one for all values (stack) and another to track minimum value at each level (minstack)
# When pushing, compare new value with current minimum and store smaller one in minstack
# This way, pop(), top() and getMin() all work in O(1) time without needing to search through stack
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