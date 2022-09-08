class MinStack(object):
    """Single variable won't be able to keep track of updating minimum.
    We can either keep 2 stacks OR a single stack and push the element as well as the new minimum every time. But that is still not space optimal.
    Best: Keep one stack and push elements and minimum only when it is updated. Worst
    case will be the same but average case will be better for this approach.
    """

    # Time Complexity of each operation is constant time.
    # Space Complexity is O(N).
    # Code submitted successfully on Leetcode.

    def __init__(self):
        self.min_stack = []
        self.min = float('inf')

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if val <= self.min:
            self.min_stack.append(self.min)
            self.min = val
        self.min_stack.append(val)

    def pop(self):
        """
        :rtype: None
        """
        if self.min_stack[-1] == self.min:
            self.min_stack.pop(-1)
            self.min = self.min_stack[-1]
            self.min_stack.pop(-1)
        else:
            self.min_stack.pop(-1)

    def top(self):
        """
        :rtype: int
        """
        return self.min_stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.min

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()