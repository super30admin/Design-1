# Time Complexity : The computational time for implementing hashmap using array in Python is O(1). Runtime: 52 ms
# Space Complexity : Memory Usage: 17.3 MB
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 
#Your code here along with comments explaining your approach
"""
# Coding Approach with Comments 
 """
import sys
class MinStack(object):
    
    def __init__(self):
        """
        initialize your data structure here.
        An array stack_items as empty array
        minimum variable equals maxsize having integer with maximum value a variable can take
        """
        self.minimum_value = sys.maxsize
        self.stack_items = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        Inserting elements/x to the array If value added is than initial minimum value set 
        it as the minimum_value
        """
        self.stack_items.append(x)
        if x < self.minimum_value:
            self.minimum_value = x

    def updateMin(self):
        """
        This function helps in updating the minimum value once the pop operation is performed
        this results in updating the stack by initializing an empty temporary stack and new minimum 
        variable with the maximum value the variable can take. Loop and pop itmes and check
        with the remaining elements if the value popped is equal to minimum value 
        update the minimum value with new minimum value by performing pop and append operation on temporary stack 
        """
        tmporaryStack = []
        new_Min = sys.maxsize
        while len(self.stack_items) > 0:  
            value = self.stack_items.pop()
            tmporaryStack.append(value)
            if value < new_Min:
                new_Min = value
        while len(tmporaryStack) > 0:
            self.stack_items.append(tmporaryStack.pop())
        self.minimum_value = new_Min

    def pop(self):
        """
        :rtype: None
        """
        value = self.stack_items.pop()
        if value == self.minimum_value:
            self.updateMin()
        return value

    def top(self):
        """
        Returns the last/newest element of stack
        :rtype: int
        """
        return self.stack_items[-1]

    def getMin(self):
        """
        Returns the minimum value of the stack
        :rtype: int
        """
        return self.minimum_value


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()