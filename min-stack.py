  
# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

class MinStack(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack1 = []
        self.stack2 = []
        self.min = float('inf')

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if x < self.min:
            self.min = x
        self.stack2.append(self.min)
        self.stack1.append(x)
        
    def pop(self):
        """
        :rtype: None
        """
        self.stack2.pop()
        if len(self.stack2) != 0:
            self.min = self.stack2[-1]
        else:
            self.min = float('inf')
        return self.stack1.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.stack1[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.stack2[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
