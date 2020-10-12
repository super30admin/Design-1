"""
Time Complexity : O(1)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
I initialized an array. For push operation, I am pushing an array  of size 2. The [0] elements contains the value
The [1] element contains the minimum value till now.
When the stack is empty, the new value is the only minimum value. When another value is added, the [1] index is
checked for the last element of stack. If that is greater than the incoming value, the incoming value
becomes the minimum, otherwise the [1] value of stack[-1] is continued as minimum value
"""


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []

    def push(self, x: int) -> None:
        temp = x
        if self.stack:
            temp = self.stack[-1][1]
            if x < temp:
                temp = x
        self.stack.append([x, temp])

    def pop(self) -> None:
        if not self.stack:
            return None
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        return self.stack[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
