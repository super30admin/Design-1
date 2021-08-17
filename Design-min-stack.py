#   Time Complexity : O(1)
#   Space Complexity : O(N)
#   Did this code successfully run on Leetcode : Yes
#   Any problem you faced while coding this : No


class MinStack(object):

    def __init__(self):
        self.minStack = []
        self.stack = []
        

    def push(self, x):
        newMinStack = {"min":x}
        if len(self.minStack):
            lastMinStack = self.minStack[len(self.minStack)-1]
            newMinStack["min"] = min(lastMinStack["min"], x)
        self.minStack.append(newMinStack)
        self.stack.append(x)
                    
    def pop(self):
        self.minStack.pop()
        return self.stack.pop()
        
    def top(self):
        return self.stack[len(self.stack)-1]
        

    def getMin(self):
        return self.minStack[len(self.stack)-1]["min"]