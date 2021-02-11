#Time Complexity :O(1)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack=[]
        self.min=[sys.maxint]

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.stack.append(x)
        mini=min(self.getMin(),x)
        self.min.append(mini)
    
    def pop(self):
        """
        :rtype: None
        """
        self.min.pop()
        self.stack.pop()
    
    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        if(len(self.min)>=1):
            return self.min[-1]
        return 


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()