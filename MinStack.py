# Time Complexity :O(1) for all the function as there is no iteration involved.
# Space Complexity : O(1) for all the functions add, remove and contains, however, core its O(n) since we are using a stack which is a list that stores all the values
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if self.minStack:
            if val < self.minStack[-1]:
                self.minStack.append(val)
            else:
                self.minStack.append(self.minStack[-1])
        else:
            self.minStack.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]

# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(10)
obj.push(20)
obj.push(30)
# obj.push(5)
# obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()
print(param_4)