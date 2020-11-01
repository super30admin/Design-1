"""
Leet : accepted
Problems: None
"""

class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.mins = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        currmin = self.getMin()
        if currmin is None or x<=currmin:
            self.mins.append(x)
        self.stack.append(x)

    def pop(self):
        """
        :rtype: None
        """
        rem = self.stack[-1]
        currmin = self.getMin()
        if rem == currmin:
            del self.mins[-1]
        del self.stack[-1]


    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        if len(self.mins) == 0:
            return None
        else:
            return self.mins[-1]
