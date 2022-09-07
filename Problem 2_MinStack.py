# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :
# // Your code here along with comments explaining your approach


class MinStack(object):

    def __init__(self):
        self.storage = []
        
# // Time Complexity : O(1)
    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if len(self.storage) > 0:
            lastMin = self.storage[-1][1]
            newMin = min(lastMin, val)
            self.storage.append([val,newMin])
        else:
            self.storage.append([val,val])
        
# // Time Complexity : O(1)
    def pop(self):
        """
        :rtype: None
        """
        self.storage.pop()
        
# // Time Complexity : O(1)
    def top(self):
        """
        :rtype: int
        """
        return self.storage[-1][0]
        
# // Time Complexity : O(1)
    def getMin(self):
        """
        :rtype: int
        """
        return self.storage[-1][1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
