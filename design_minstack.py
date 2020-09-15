"""
- Problem: Design MinStack (https://leetcode.com/problems/min-stack/)
    - Design a SplStack that supports all the stack operations push, pop, isEmpty, isFull and
        an operation getMin() which should return minimum element from the SplStack.
    - All these operations must be O(1).
    - To implement this, you should only use standard Stack data structure.
- Time Complexity : O(1) for all operations.
- Space Complexity : O(n). Worst case is that all the operations are push.
"""


class MyMinStack:
    def __init__(self):
        # initialize data structure here.
        self.stack = []

    def push(self, x: int) -> None:
        # pushed and min number are same for the first instance
        if not self.stack:
            self.stack.append((x, x))
            return

        # min is the second element from previous number
        current_min = self.stack[-1][1]
        self.stack.append((x, min(x, current_min)))

    def pop(self) -> None:
        self.stack.pop()

    def top(self) -> int:
        # top is the first element from previous number
        return self.stack[-1][0]

    def getMin(self) -> int:
        # min is the second element from previous number
        return self.stack[-1][1]


# Driver code
obj = MyMinStack()
obj.push(3)
obj.push(5)
obj.push(6)
obj.push(8)
obj.pop()
print("Top number in stack: ",obj.top())
print("Minimum number in stack", obj.getMin())