"""
// Time Complexity : o(1)
// Space Complexity : o(n), size of stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""

class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack=[] #the data structure
        self.min_st=[] #stack to mainitain the min value at any point of time
        
    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if not self.stack: # if there are no elemnets 
            self.min_st.append(x) #add the value to min_st
        elif x<=self.min_st[-1]: #else add the value to min_st only if it is smaller than the running min value
            self.min_st.append(x)
            
        self.stack.append(x) #add the value to the stack
        
    def pop(self):
        """
        :rtype: None
        """
        popped=self.stack.pop() #pop the value
        if popped == self.min_st[-1]: #if the value is equal to the running min value, remove it from min_st too
            self.min_st.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1] #returns top of stack
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.min_st[-1] #returns top of min_st
        
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()