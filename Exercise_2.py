class MinStack(object):
    # Time Complexity : O(1)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No
    def __init__(self):
        self.stack = []
        self.min = float('inf')
        

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if self.min >= val:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)
        
            

    def pop(self):
        """
        :rtype: None
        """
        if(self.min == self.stack[-1]):
            self.stack.pop()
            self.min = self.top()
            self.stack.pop()
        else:
            self.stack.pop()
            
            

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1] if len(self.stack)>0 else None
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.min

# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(-3)
obj.getMin()
obj.pop()
obj.top()
print(obj.getMin())