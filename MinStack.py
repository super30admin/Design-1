#Time Complexity : O(1)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : syntax issues 


#Your code here along with comments explaining your approach

class MinStack(object):

    def __init__(self):
        self.stack=[]            #define a stack
        

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if not self.stack:     #check if the stack is empty
            self.stack.append((val,val)) # append 2 values(value, minval)
            return
        overall_min=self.stack[-1][1]   # find the previous min which is the second element 
        curr_min=min(val,overall_min)   # find the present min 
        self.stack.append((val,curr_min)) # append the (value, min)
        

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()    #pop the top element 
        

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1][0]  # obtain the top value 
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.stack[-1][1]  # obtain the min value
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()