"""Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.data = []

    def push(self, val: int) -> None:
        if not self.data:
            self.data.append((val,val))
            return
        mini = self.data[-1][1]
        self.data.append((val, min(val, mini)))
        

    def pop(self) -> None:
        popped = self.data[-1]
        del self.data[-1]
        return popped

    def top(self) -> int:
        return self.data[-1][0]

    def getMin(self) -> int:
        return self.data[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()