# Time Complexity : 0(1)
# Space Complexity : 
# Did this code successfully run on Leetcode : yes 
# Any problem you faced while coding this : 
# Your code here along with comments explaining your approach

class MinStack:

    def __init__(self):
        self.st = []
        self.minSt = []
        self.min = float('inf')
        self.minSt.append(self.min)
        

    def push(self, val: int) -> None:
        self.min = min(self.min, val)
        self.st.append(val)
        self.minSt.append(self.min)
        

    def pop(self) -> None:
        self.st.pop()
        self.minSt.pop()
        self.min =self.minSt.peek()

    def top(self) -> int:
        if self.st:
            return self.minSt.peek()
        

    def getMin(self) -> int:
        return self.min