"""
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:
MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Approach --
1.

Time complexity - O(1)
Space Complexity - O(n)
"""
import sys


class MinStack:

    def __init__(self):
        self.mstack = []
        self.minimum = sys.maxsize

    def push(self, val: int) -> None:
        if val <= self.minimum:
            self.mstack.append(self.minimum)
            self.mstack.append(val)
            self.minimum = val
            return
        self.mstack.append(val)

    def pop(self) -> None:
        if self.mstack[-1] == self.minimum:
            self.mstack.pop()
            self.minimum = self.mstack[-1]
            self.mstack.pop()
            return
        self.mstack.pop()

    def top(self) -> int:
        return self.mstack[-1]

    def getMin(self) -> int:
        return self.minimum

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()