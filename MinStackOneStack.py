'''
// Time Complexity : O(1)
// Space Complexity : O(2n) --- Only in worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach'''
import sys
from collections import deque
class MinStack(object):

#Method 2 Take one stack and for every push store the previous min value below it if min<= val
    def __init__(self):
        self.mainStack=deque()       
        #Max integer from the system
        self.prevMin=sys.maxint
        self.mainStack.append(self.prevMin)
        
    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        #if the new element is equal to the current min then we have to append the prev min as well, else it will pop the current value twice
        if(val<=self.prevMin):  
            self.mainStack.append(self.prevMin)
            self.prevMin=val
            self.mainStack.append(val)
        else:
            self.mainStack.append(val)
          

    def pop(self):
        """
        :rtype: None
        """
        if self.mainStack != self.isEmpty():
            #if the popped element is equal to the current minimum then pop twice
            if(self.prevMin == self.mainStack.pop()):   
                self.prevMin=self.mainStack.pop()
            
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
        
        return self.prevMin


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
