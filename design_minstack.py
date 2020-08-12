#space complexity: O(n)

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.currentMin = float("-inf")
        

    def push(self, x: int) -> None:
        if not self.stack and self.currentMin == float("-inf"):
            self.currentMin = x
        else:
            self.stack.append(x - self.currentMin)
            if x < self.currentMin:
                self.currentMin = x

    def pop(self) -> None:
        if not self.stack:
            ret = self.currentMin
            self.currentMin = float("-inf")
            return ret
        if self.stack[-1] >= 0:
            return self.stack.pop() + self.currentMin
        ret = self.currentMin
        self.currentMin -= self.stack.pop()
        return ret

        

    def top(self) -> int:
        if self.stack and self.stack[-1] >= 0:
            return self.stack[-1] + self.currentMin
        return self.currentMin
        

    def getMin(self) -> int:
        return self.currentMin
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
