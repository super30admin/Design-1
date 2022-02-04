# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MinStack:

    def __init__(self):
        self.s1=[]
        self.s2=[]
        

    def push(self, val: int) -> None:
        self.s1.append(val)
        if not self.s2 or val <= self.s2[-1]:
            self.s2.append(val)
        

    def pop(self) -> None:
        if not self.s1:
            return -1
        temp=self.s1.pop()
        if temp==self.s2[-1]:
            self.s2.pop()
        

    def top(self) -> int:
        if not self.s1:
            return -1
        return self.s1[-1]
        

    def getMin(self) -> int:
        if not self.s2:
            return -1
        return self.s2[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()