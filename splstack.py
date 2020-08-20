# Time Complexity : 0(1)
# Space Complexity : 0(2N) N=no. of elements in the stack
# Did this code successfully run on Leetcode : Yes. 
# Any problem you faced while coding this : Nothing specific. 


# Your code here along with comments explaining your approach

class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        
        self.stack=[]
        self.min=float('inf')
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        
        if x<=self.min:
            self.stack.append(self.min)
            self.min=x
        
        self.stack.append(x)

    def pop(self):
        """
        :rtype: None
        """
        element=self.stack.pop(-1)
        if self.min==element:
            
            self.min=self.stack.pop(-1)
        
        return element
        
    def top(self):
        """
        :rtype: int
        """
        
        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        
        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()