"""
- Problem: Design MinStack (https://leetcode.com/problems/min-stack/)
    - Design a SplStack that supports all the stack operations push, pop, isEmpty, isFull and
        an operation getMin() which should return minimum element from the SplStack.
    - All these operations must be O(1).
    - To implement this, you should only use standard Stack data structure.
- Time Complexity : O(1) for all operations.
- Space Complexity : O(n). Worst case is that all the operations are push.
"""


class MinStack:
    def __init__(self):
        # initialize your data structure here.
        self.stack = []
        self.min = float('inf') # Max finite value

    def push(self, x: int):
        # If num is less than min, push min to stack first and then push the number to the stack
        if x <= self.min:
            self.stack.append(self.min)
            self.min = x
        self.stack.append(x)

    def pop(self):
        if len(self.stack) > 0:
            if self.stack.pop() == self.min:
                self.min = self.stack.pop()

    def top(self):
        if len(self.stack) > 0:
            print("Top number in stack: ", self.stack[-1])
        return -1

    def getMin(self):
        print("Minimum number in stack: ", self.min)

    def displayStack(self):
        print(self.stack)


# Driver code
obj = MinStack()
obj.push(-1)
obj.push(3)
obj.push(1)
obj.push(-1)
obj.displayStack()
obj.pop()
obj.displayStack()
obj.top()
obj.getMin()