# Time Complexity : O(n)
#
# Space Complexity :
# O(n)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :
#
#
# Your code here along with comments explaining your approach

class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.array = []

    def isEmpty(self):
        if len(self.array) == 0:
            return True
        return False

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.array.append(val)

    def pop(self):
        """
        :rtype: None
        """
        self.array.pop(-1)

    def top(self):
        """
        :rtype: int
        """
        if self.isEmpty():
            return None
        return self.array[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return min(self.array)

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()