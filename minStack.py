# Time Complexity : O(1) for push, pop, top, and getMin
# Space Complexity : O(N) for the size of the stack (number of elements pushed into stack)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.mainStack = []
        self.minStack = []

    def push(self, x: int) -> None:
        if not self.mainStack and not self.minStack:
            self.mainStack.append(x)
            self.minStack.append(x)
        else:
            self.mainStack.append(x)
            if x <= self.minStack[-1]:
                self.minStack.append(x)
            
    def pop(self) -> None:
        if self.mainStack and self.minStack:
            check = self.mainStack.pop()
            if check == self.minStack[-1]:
                self.minStack.pop()

    def top(self) -> int:
        return self.mainStack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()