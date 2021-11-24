import sys
class MinStack(object):

    def __init__(self):
        self.stack = []        
        self.minstack = []
        self.minstack.append(sys.maxsize)
    
    def push(self, val):
        self.stack.append(val)
        self.minstack.append(min(val, self.minstack[-1]))
        
    def pop(self):
        self.stack.pop()
        self.minstack.pop()
                
    def top(self):
        return self.stack[-1]
        
    def getMin(self):
        return self.minstack[-1]
        
