# Time Complexity : push, pop, top, getMin O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class MinStack:

    def __init__(self):
        self.st = []
        self.minSt = [float('inf')]
        self.currMin = float('inf')
        

    def push(self, val: int) -> None:
        self.currMin = min(self.minSt[-1], val)
        self.st.append(val)
        self.minSt.append(self.currMin)
        

    def pop(self) -> None:
        self.st.pop()
        self.minSt.pop()
        self.currMin = self.minSt[-1]
        

    def top(self) -> int:
        return self.st[-1]
        

    def getMin(self) -> int:
        return self.minSt[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()