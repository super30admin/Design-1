# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

class MinStack:

    # MinStack constructor - stack keeps track of order of elements, minimum stack keeps track of the current minimum
    def __init__(self):
        self.stack = []
        self.minimumstack = []

    # Push the value to stack. If the value is less than or equal to top element of minimum stack, then push it to minimumstack too.
    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.minimumstack or val <= self.minimumstack[-1]:
            self.minimumstack.append(val)

    # First check if the element at top of the stack is also the present minimum (element at top of minimumstack).
    # If yes, then remove it from both stack and minimumstack. Else remove it from stack only
    def pop(self) -> None:
        if self.stack[-1] == self.minimumstack[-1]:
            self.minimumstack.pop()
        self.stack.pop()

    # Return the element at the top of the stack
    def top(self) -> int:
        return self.stack[-1]

    # Return the element at the top of the minimumstack
    def getMin(self) -> int:
        return self.minimumstack[-1]

obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(-3)
print(obj.getMin())
obj.pop()
print(obj.top())
print(obj.getMin())