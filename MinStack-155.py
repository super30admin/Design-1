# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I was initially working by storing min in another stack. After the class, I changed the working to a single stack


# Your code here along with comments explaining your approach 

class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack1 = []              # Initialized a stack
        self.min = float('inf')       # Current min value
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if x <= self.min:                     # If the value to be pushed is less than current min
            self.stack1.append(self.min)      # Append the current min
            self.min = x                      # Change the min to the value
        
        self.stack1.append(x)                 # Append the value
        

    def pop(self):
        """
        :rtype: None
        """
        popped = self.stack1.pop()           # Pop the first element of stack
        
        if popped == self.min:               # If it is equal to the current min,  
            self.min = self.stack1.pop()     # that means need to pop the next value (which we pushed everytime we encounter a value less than min) 
                                             # and change it's value to current min
    def top(self):
        """
        :rtype: int
        """
        return self.stack1[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.min
        
mn = MinStack()
mn.push(2)
mn.push(0)
mn.push(3)
mn.pop()
print mn.top()
print mn.getMin()