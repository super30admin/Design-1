"""
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

Created to stacks. One for regular operations and other for maintaining min values
push:will push values into the stack. 
if min_stack is empty or value is less than the last appended value into min_stack push value into min stack
else(value is greater than the last pushed value of min_stack ) we append the last value of min_stack
pop: we pop from both stacks
top: if stack is not empty we return the top value of main stack
getMin: return the top value of min_stack if min_stack is not empty

Time complexity for all the operations id O(1)
space complexity O(N)

"""

class MinStack:

    def __init__(self):
        self.stack =[]
        self.min_stack = []
        

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)
        else:
            self.min_stack.append(self.min_stack[-1])        

    def pop(self) -> None:
        if self.stack:
            self.min_stack.pop()
            self.stack.pop()
        

    def top(self) -> int:
        if self.stack:
            return self.stack[-1]
        return -1
        

    def getMin(self) -> int:
        if self.min_stack:
            return self.min_stack[-1]
        return -1
    
output = [None]
minStack = MinStack()
output.append(minStack.push(-2))
output.append(minStack.push(0))
output.append(minStack.push(-3))
output.append(minStack.getMin()) # return -3
output.append(minStack.pop())
output.append(minStack.top())   # return 0
output.append(minStack.getMin()) # return -2

print(output)