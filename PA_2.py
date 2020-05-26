#Leetcode 155 : Min Stack
#Time Complexity - O(n)
#Space Complexity - O(n)

class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = 2147483650
        self.stack.append(self.min)
        self.size = 0
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.size = self.size + 1
        if x <= self.min:
            self.size = self.size + 1
            self.stack.append(self.min)
            self.min = x
        self.stack.append(x)
        
    def pop(self):
        """
        :rtype: None
        """
        self.size = self.size - 1
        x = self.stack.pop()
        if x == self.min:
            self.size = self.size - 1
            self.min = self.stack.pop()
        return x
        
    def top(self):
        """
        :rtype: int
        """
        return self.stack[self.size]

    def getMin(self):
        """
        :rtype: int
        """
        return self.min