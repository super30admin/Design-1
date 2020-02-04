class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        # O(1) Time Complexity | O(n) Space Complexity for extra stack overall
        self.mainStack = []
        self.helperStack = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        # O(1) Time Complexity | O(1) Space Complexity
        self.mainStack.append(x)
        if len(self.helperStack) == 0:                  # if helper stack is empty, then push x directly
            self.helperStack.append(x)
        else:                                           # if helper stack is non-empty, then compare x and top-min element
            minimum_val = min(x, self.getMin())
            self.helperStack.append(minimum_val)

    def pop(self):
        """
        :rtype: None
        """
        # O(1) Time Complexity | O(1) Space Complexity
        if len(self.mainStack) == 0:
            return None
        self.mainStack.pop()
        self.helperStack.pop()

    def top(self):
        """
        :rtype: int
        """
        # O(1) Time Complexity | O(1) Space Complexity
        if len(self.mainStack) == 0:
            return None
        return self.mainStack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        # O(1) Time Complexity | O(1) Space Complexity
        if len(self.mainStack) == 0:
            return None
        return self.helperStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()