# Time Complexity: O(1)
# Space Complexity: O(N)
# Any problem you faced while coding this : No
# Did this code successfully run on Leetcode: Yes

class MinStack(object):
    
    def __init__(self):
        self.stack =[]
        self.minStack = []

    def push(self, element):
        self.stack.append(element)
        if (not self.minStack) or (element<=self.minStack[-1]):
            self.minStack.append(element)

    def pop(self):
        if self.stack[-1] == self.minStack[-1]:
            self.minStack.pop()
        self.stack.pop()

    def top(self):
        return self.stack[-1]

    def getMin(self):
        return self.minStack[-1]