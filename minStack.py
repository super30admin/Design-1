'''
time complexity: O(n)
space complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
'''
class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []
        self.minimum = float('inf')
        self.minStack.append(self.minimum)

    def push(self, val: int) -> None:
        self.stack.append(val)
        mini = min(self.stack[-1],self.minimum)
        self.minStack.append(mini)
        self.minimum = self.minStack[-1]

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()
        self.minimum = self.minStack[-1]
        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.minimum


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()