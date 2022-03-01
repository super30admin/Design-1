#Time Complexity : O(1)
#Space Complexity : O(2n)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : Runtime is greater

class MinStack:

    def __init__(self):
        self.li = []
        self.min = []

    def push(self, val: int) -> None:
        
        self.li.append(val)
        if not self.min or val <= self.min[-1]:
            self.min.append(val)

    def pop(self) -> None:
        if self.min[-1] == self.li[-1]:
            self.min.pop()
        self.li.pop()

    def top(self) -> int:
        return self.li[-1]

    def getMin(self) -> int:
        return self.min[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()