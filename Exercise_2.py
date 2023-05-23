"""
Created stack array list for regular stack operation
Created minstack array list to store only minimum numbers in the original array till particular index
getting last element in minstack, comparing with value being pushed, only pushing in minstack if less that what is there already

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Time Complexity - 
push - O(1)
pop - O(1)
top - O(1)
getMin - O(1)
isEmpty - O(1)

Space Complexity - O(n)
"""

class MinStack(object):

    def __init__(self):
        self.minstack=[]
        self.stack=[]

    def push(self, val):
        self.stack.append(val)
        if len(self.minstack)==0:
            self.minstack.append(val)
        else:
            minval=min(self.minstack[-1],val)
            self.minstack.append(minval)
        

    def pop(self):
        self.stack.pop()
        self.minstack.pop()
        return self.stack
        

    def top(self):
        return self.stack[-1]
        

    def getMin(self):
        return self.minstack[-1]
        
    def isEmpty(self):
        if self.stack:
            return False
        else:
            return True

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()