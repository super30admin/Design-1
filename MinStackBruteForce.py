'''
// Time Complexity : O(1)
// Space Complexity : O(2n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach'''
import sys
from collections import deque
class MinStack(object):

    #Brute force--> Create 2 stacks with one to one mapping
    def __init__(self):
        self.mainStack=deque()
        self.minStack=deque()
        
        #Max integer from the system
        self.minStack.append(sys.maxint)
    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        #Append the value in the main stack
        self.mainStack.append(val)
        
        #Append the value in the min stack, the minimum value between the previous minimum value and the current value appended in the main stack
        self.minStack.append(min(self.minStack[-1],val))    

    def pop(self):
        """
        :rtype: None
        """
        #Pop from both
        if self.mainStack != self.isEmpty():
            self.mainStack.pop()
            self.minStack.pop()
    #Check if empty
    def isEmpty(self):
        return len(self.mainStack)==0

      #Peek method in stack implementation
    def top(self):
        """
        :rtype: int
        """
        return self.mainStack[-1]
        
    #Return current min
    def getMin(self):
        """
        :rtype: int
        
        
        """ 
        
        return self.minStack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
