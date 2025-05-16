# Time Complexity :
# push(): O(1)
# pop(): O(1)
# top(): O(1)
#getMin() : O(1)

# Space Complexity : O(n)  

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Approach: ne stack (stack) to store values and another stack (min_stack) to track 
# the current minimum at each step, so getMin() is O(1).

class MinStack(object):

    def __init__(self):
        self.stack = []      
        self.min_stack = []
        

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)
        else:
            self.min_stack.append(self.min_stack[-1])
        

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        self.min_stack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.min_stack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()