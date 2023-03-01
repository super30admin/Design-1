"""
time complexity - O(1) for all the operations
"""

class MinStack:

    def __init__(self):
        self.ls=[]
        self.min_ls=[]

    def push(self, val: int) -> None:
        self.ls.append(val)
        val=min(val,self.min_ls[-1] if self.min_ls else val)
        self.min_ls.append(val)
    
    def pop(self) -> None:
        self.ls.pop()
        self.min_ls.pop()

    def top(self) -> int:
        return self.ls[-1]

    def getMin(self) -> int:
        return self.min_ls[-1]   


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
