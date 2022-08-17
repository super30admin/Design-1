"""
Assignment 3 - [155 medium] MinStack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
You must implement a solution with O(1) time complexity for each function.
"""
# Time Complexity: O(1)
# Space complexity: O(n)


class MinStack(object):

    def __init__(self):     # initialise 2 arrays(stacks)
        self.stack = []     # stack elements
        self.minStack = []  # this array will maintain array of minimum values..min value will be at top

    def push(self, val):
        self.stack.append(val)  # push value to stack[]
        val = min(val, self.minStack[-1] if self.minStack else val)  # compare min among value and the top of minStack[] (if minStack is not None)
        self.minStack.append(val)  # push min value

    def pop(self):
        self.stack.pop()  # pop from both stacks
        self.minStack.pop()

    def top(self):
        return self.stack[-1]  # return top of stack[]

    def getMin(self):
        return self.minStack[-1]  # top of minStack will be minimum value

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()