class MinStack:
    # Time Complexity : O(1)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No
    def __init__(self):
        self.stack = []
        self.minstack = []

    # Time Complexity : O(1)
    # Space Complexity : O(n)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No
    def push(self, val: int) -> None:
        if len(self.minstack) == 0 or val <= self.minstack[len(self.minstack) - 1]:
            self.minstack.append(val)
        self.stack.append(val)

    # Time Complexity : O(1)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No
    def pop(self) -> None:
        if self.stack[len(self.stack) - 1] == self.minstack[len(self.minstack) - 1]:
            self.minstack.pop()
        self.stack.pop()

    # Time Complexity : O(1)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No
    def top(self) -> int:
        return self.stack[len(self.stack) - 1]

    # Time Complexity : O(1)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No
    def getMin(self) -> int:
        return self.minstack[len(self.minstack) - 1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
