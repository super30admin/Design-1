#!/usr/bin/env python
# coding: utf-8

# In[ ]:


class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []
        self.min_value = inf
        
    # TC = O(1) 
    def push(self, val):
        self.min_value = min(self.min_value, val)
        self.stack.append(val)
        self.min_stack.append(self.min_value)

    # TC = O(1)
    def pop(self):
        self.stack.pop()
        self.min_stack.pop()
        if len(self.min_stack) == 0:
            self.min_value = inf
        else:
            self.min_value = self.min_stack[-1]
        #print("pop", self.min_value)
        
    def top(self):
        return self.stack[-1]
    
    # TC = O(n)
    def getMin(self):
        return self.min_value
    
# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

