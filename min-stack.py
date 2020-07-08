  
# Time Complexity : for getMin: O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Could not figure out an approach to getMin in O(1)

class MinStack(object):
    arr = []
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.arr = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.arr.append(x)

    def pop(self):
        """
        :rtype: None
        """
        return self.arr.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.arr[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return min(self.arr)


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
