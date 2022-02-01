
#Time Complexity :
#Space Complexity :
#Did this code successfully run on Leetcode : Yes 

class MinStack:

    def __init__(self):
        self.s1 = [ ]
        self.s2 = [ ]

    def push(self, val: int) -> None:
        self.s1.append(val)
        if self.s2 != [] and self.s2[len(self.s2) - 1] < val :
            self.s2.append(self.s2[len(self.s2) - 1])
        else:
            self.s2.append(val)
        
    def pop(self) -> None:
        self.s1.pop()
        self.s2.pop()

    def top(self) -> int:
        return self.s1[len(self.s1) - 1]
        
    def getMin(self) -> int:
        return self.s2[len(self.s2) - 1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()