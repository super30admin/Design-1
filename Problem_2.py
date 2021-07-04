# Time Complexity :O(1)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.myStack = []
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if len(self.myStack) ==0:
            #if empty stack append the intiger and minumum is the intiger
            self.myStack.append((x,x))
        else:
            # if not empty append the intiger and check are this number less than the last min and put min at this stage
            self.myStack.append((x,min(x,self.myStack[-1][1])))
        

    def pop(self):
        """
        :rtype: None
        """
        if len(self.myStack) > 0:
            self.myStack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        if len(self.myStack) > 0:
            return self.myStack[-1][0]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.myStack[-1][1]
        
