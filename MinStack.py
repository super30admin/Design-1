# Design a SplStack that supports all the stack operations push, pop, isEmpty, isFull and an operation getMin()
# which should return minimum element from the SplStack.
# All these operations must be O(1). To implement this, you should only use standard Stack data structure.
# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Yes, in the push function I missed checking for an empty stack initially.
# Later fixed it by adding a condition
class MinStack(object):

    def __init__(self):
        # the stack is going to hold data as tuples of the form (value, min_value )
        # value - current value to be inserted
        # min_value - minimum value of the stack at that point in time.
        self.stack = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        # if the stack is empty, then the current value is the minimum so far
        if not self.stack:
            self.stack.append((val, val))
        else:
            value, minimum = self.stack[-1]
            self.stack.append((val, min(minimum, val)))

    def pop(self):
        """
        :rtype: None
        """
        #
        self.stack.pop()

    def top(self):
        """
        :rtype: int
        """
        # return the top value from the top most tuple
        top_val, top_min = self.stack[-1]
        return top_val

    def getMin(self):
        """
        :rtype: int
        """
        # the top most tuple's minimum val
        top_val, top_min = self.stack[-1]
        return top_min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
