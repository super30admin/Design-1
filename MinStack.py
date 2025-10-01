# 155. Min Stack

# Time Complexity: O(n)
# Space Complexity: O(n)

class MinStack(object):
    def __init__(self):
        self.minStack = list()

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if len(self.minStack):
            currMin = self.minStack[-1][1]
            self.minStack.append((val, min([val, currMin])))
        else:
            self.minStack.append((val,val))

    def pop(self):
        """
        :rtype: None
        """
        if not len(self.minStack):
            return
        else:
            self.minStack.pop()        

    def top(self):
        """
        :rtype: int
        """
        return self.minStack[-1][0] 
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.minStack[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()