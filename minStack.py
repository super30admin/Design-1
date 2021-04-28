"""
Space Complexity: O(2n) = O(n)
Runtime Complexity:
push --> O(1)
pop --> O(1)
top --> O(1)
getMin --> O(1)
"""

# using two stacks
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = list()
        self.min = list()
        self.min.append(float('inf'))

    def push(self, val: int) -> None:
        self.stack.append(val)
        if val < self.min[-1]:
            self.min.append(val)
        else:
            self.min.append(self.min[-1])

    def pop(self) -> None:
        self.stack.pop()
        self.min.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        # minVal = 10000000000
        # for i in self.stack:
        #     if i < minVal:
        #         minVal = i
        # return minVal
        # return min(self.stack)
        return self.min[-1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()