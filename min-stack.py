# Time Complexity - O(1)
# Space Complexity - O(n) (stack to store n values)
class MinStack:

    def __init__(self):
        self.stack = []
        self.minEle = float('inf')
        
    def push(self, val: int) -> None:
        if val <= self.minEle:
            self.stack.append(self.minEle)
            self.minEle = val
        self.stack.append(val)

    def pop(self) -> None:
        pop = self.stack.pop()
        if pop == self.minEle:
            self.minEle = self.stack.pop()

    def top(self) -> int:
        return self.stack[len(self.stack) - 1]
        
    def getMin(self) -> int:
        return self.minEle


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()