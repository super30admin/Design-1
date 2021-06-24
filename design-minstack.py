import sys

class MinStack(object):
    # 1st approach - Single stack
    # every time minimum is encountered, 
    # push the old minimum first and then the new minimum onto the stack
    # time complexity - O(1) for all operations
    # space complexity - O(1)
    def __init__(self):
        self.stack = []
        self.stack.append(sys.maxsize)
        self.min = self.stack[-1]

        
    def push(self, val):
        if val <= self.min:
            self.stack.append(self.min)
            self.stack.append(val)
            self.min = val
        else:
            self.stack.append(val)
        

    def pop(self):
        if self.stack[-1] == self.min:
            self.stack.pop()
            self.min = self.stack[-1]
            self.stack.pop()
        else:
            self.stack.pop()
        

    def top(self):
        return self.stack[-1]
        

    def getMin(self):
        return self.min
    
    
    # 2nd approach - 2 stack
    # stack - pushes and pop as required
    # min_stack - pushes element only if it less than min else pushes min again
    # time complexity - O(1) for all opeations
    # space complexity - O(2n) - ignore constants so it is O(n)
    """
    def __init__(self):
        self.min_stack = []
        self.stack = []
        self.min_stack.append(sys.maxsize)
        

    def push(self, val):
        if val <= self.min_stack[-1]:
            self.min_stack.append(val)
        else:
            self.min_stack.append(self.min_stack[-1])
        self.stack.append(val)

    def pop(self):
        self.stack.pop()
        self.min_stack.pop()
        

    def top(self):
        if self.stack:
            return self.stack[-1]
        

    def getMin(self):
        if self.stack:
            return self.min_stack[-1] """


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()