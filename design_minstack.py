# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no, only understanding the concept but once i understood it, coding was straightforward


# Your code here along with comments explaining your approach
# It look me a little bit to understand minstack but I came to the conclusion that two lists are needed for it: one to keep track of a normal stack, and one to keep track of the minimum value for constant time retrieval. Once I understood that, the rest of the functions was pretty self explanatory and straighforward


class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []

    # Time: O(1)
    # Space: O(1)
    def push(self, val: int) -> None:
        self.stack.append(val)
        if len(self.minStack) == 0 or val <= self.minStack[-1]:
            self.minStack.append(val)

    # Time: O(1)
    # Space: O(1)
    def pop(self) -> None:
        val = self.stack.pop()
        if val == self.minStack[-1]:
            self.minStack.pop()

    # Time: O(1)
    # Space: O(1)
    def top(self) -> int:
        return self.stack[-1]

    # Time: O(1)
    # Space: O(1)
    def getMin(self) -> int:
        return self.minStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
