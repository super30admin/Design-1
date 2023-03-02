# Time Complexity : O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []
        self.min = sys.maxsize
        self.minStack.append(self.min)
        
    def push(self, val: int) -> None:
        self.stack.append(val)
        if val <= self.min:
            self.minStack.append(self.min)
            self.min = val
        

    def pop(self) -> None:
        element = self.stack.pop()
        if element == self.min:
            self.min = self.minStack.pop()


        

    def top(self) -> int:
        return self.stack[len(self.stack)-1]

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()