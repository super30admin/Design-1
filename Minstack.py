# Time Complexity for push/pop/getMin is O(1)
# space Complexity for push/pop/getMin is O(n)
class MinStack(object):

    def __init__(self):
        self.stack = []
        self.minStack = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.stack.append(val)
        val = min(val, self.minStack[-1] if self.minStack else val)
        
        self.minStack.append(val)


    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        self.minStack.pop()
        

    def top(self):
        """
        :rtype: int
        """

        return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.minStack[-1]
        

minStack = MinStack()
minStack.push(-2)
minStack.push(0)
minStack.push(-3)
print(minStack.getMin()) # return -3
minStack.pop()
minStack.top()    # return 0
print(minStack.getMin()) # return -2

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()