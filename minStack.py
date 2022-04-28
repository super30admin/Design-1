# Time: O(1)
# Space: O(n)
# Executed successfully on Leetcode
# No challenges faced

class MinStack:

    def __init__(self):
        self.arr =  []

    def push(self, val: int) -> None:
        self.arr.append((val,val if not self.arr else min(val,self.arr[-1][-1])))
        

    def pop(self) -> None:
        self.arr.pop()
        

    def top(self) -> int:
        return self.arr[-1][0]
        

    def getMin(self) -> int:
        return self.arr[-1][1]