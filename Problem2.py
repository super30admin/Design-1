# Time Complexity :- contains O(1) all functions
# Space Complexity : - O(N) where N is the number of inputs 
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : Time Limit Exceeded 


class MinStack:

    def __init__(self):
        self.stack = []
        self.stackMin = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if self.stackMin != []:
            self.stackMin.append(min(self.stackMin[-1], val))
        else:
            self.stackMin.append(val)

    def pop(self) -> None:
        if self.stack is not None:
            del(self.stack[-1])
        if self.stackMin is not None:
            del(self.stackMin[-1])  

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.stackMin[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()