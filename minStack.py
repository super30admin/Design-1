#time:O(1) and space O(1) for all the functions.
import sys
class MinStack:

    def __init__(self):#time:O(1) and space O(1)
        self.arr=[]
        self.m=sys.maxsize

    def push(self, val: int) -> None:
        if val<=self.m:
            self.arr.append(self.m)
            self.m=val
        self.arr.append(val)

    def pop(self) -> None:
        if self.arr.pop()==self.m:
            self.m=self.arr.pop()

    def top(self) -> int:
        return self.arr[-1]

    def getMin(self) -> int:
        return self.m


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
