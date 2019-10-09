"""
Use one stack to maintain data. push min_value if min value changes

push and pop are O(1)

"""

class MinStack(object):
    stack = [None]
    min_value = None
    
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = [None]
        self.min_value = None
    
    def push(self, k):
        """
        :type x: int
        :rtype: None
        """
        if (self.min_value is None ) or (self.min_value >= k) :
            self.stack.append(self.min_value)
            self.min_value = k
        
        self.stack.append(k)
    
    
    def pop(self):
        """
        :rtype: None
        """
        r = self.stack.pop()
        if r == self.min_value :
            self.min_value = self.stack.pop()
        
        return r
    
    
    
    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]
    
    
    def getMin(self):
        """
        :rtype: int
        """
        return self.min_value
    
    
    
    # Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()