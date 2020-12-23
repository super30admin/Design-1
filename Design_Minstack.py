# Created by Aashish Adhikari at 12:42 PM 12/23/2020

#Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        from collections import deque

        # Maintain two stacks
        self.elements = deque()
        self.corresponding_minimum = deque()


    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.elements.append(x)
        if len(self.corresponding_minimum) != 0:
            if self.corresponding_minimum[-1] < x:
                self.corresponding_minimum.append(self.corresponding_minimum[-1])
            else:
                self.corresponding_minimum.append(x)
        else:
            self.corresponding_minimum.append(x)




    def pop(self):
        """
        :rtype: None
        """
        self.corresponding_minimum.pop()
        return self.elements.pop()


    def top(self):
        """
        :rtype: int
        """
        return self.elements[-1]


    def getMin(self):
        """
        :rtype: int
        """
        return self.corresponding_minimum[-1]



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()