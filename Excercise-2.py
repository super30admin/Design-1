# Time Complexity : O(1)
# Space Complexity :O(n) #For MinStack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No

class MinStack(object):

    def __init__(self):
        self.stack=[]
        self.MinStack=[]     

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.stack.append(val)
        if(self.MinStack!=[]):
            self.MinStack.append(min(val,self.MinStack[-1]))
        else:
            self.MinStack.append(val)

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        self.MinStack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return(self.stack[-1])
        

    def getMin(self):
        """
        :rtype: int
        """
        return(self.MinStack[-1])
        


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(-3)
obj.push(10)
obj.push(-1)

obj.pop()
print(obj.top())
print(obj.getMin())