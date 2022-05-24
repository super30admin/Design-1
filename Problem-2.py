# Time Complexity : O(1)
#Space Complexity : O(N) since we create a minStack to keep track of the minimum value
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

# We create a minStack arr that keeps track of the minimum value added to the stack and the top of it always contains the minimum value
# and even if we pop the top element from the stack, we pop the top element from the minStack also and in that way we get the minimum value
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