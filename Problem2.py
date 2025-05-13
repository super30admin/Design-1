# Time Complexity:
# - push: O(1)
# - pop: O(1)
# - top: O(1)
# - getMin: O(1)
#
# Space Complexity: O(n), where n is the number of elements pushed onto the stack
#
# Successfully ran on Leetcode: Yes
# Challenges faced: None


class MinStack(object):

    def __init__(self):
        self.min = []
        self.stack = []
        

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """

        self.stack.append(val)
        if not self.min or val <= self.min[-1]:
            self.min.append(val)



    def pop(self):
        """
        :rtype: None
        """
        value = self.stack.pop()
        if self.min[-1] == value:
            self.min.pop()
    def top(self):
        """
        :rtype: int
        """

        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """

        return self.min[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()