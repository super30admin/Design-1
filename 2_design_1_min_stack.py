#Time Complexity : O(1) for every operation 
#Space Complexity : n+n for the worst case, O(n) for using stack
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : I used two stacks for keeping track for minimum values. How could I implement using one stack? 


#Your code here along with comments explaining your approach


class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.main_stack=[] #For keeping track of all the values 
        self.min_stack=[] # For keeping track of minimum values
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.main_stack.append(x) # Always append the values in main stack
        if not self.min_stack or x<=self.min_stack[-1]: # Always append the values in min stack if and only if the value is lesser than the previous one 
            self.min_stack.append(x)
        

    def pop(self):
        """
        :rtype: None
        """
        if self.main_stack[-1]==self.min_stack[-1]: #Don't pop the element from Min stack if both the last elements of min and main stack are not same
            self.min_stack.pop()
        self.main_stack.pop()    #every time we can pop from main stack irrespective of any condition
        

    def top(self):
        """
        :rtype: int
        """
        return self.main_stack[-1] #Always top of the main stack
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.min_stack[-1] #Always top of min stack


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
