# https://leetcode.com/problems/min-stack
# Time Complexity : O(1) for all of the functions
# Space Complexity : upto O(2n) for stack in worst case but dropping constants its O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach


class MinStack:

    def __init__(self):
        self.min = float("inf")
        self.l = [self.min]

    def push(self, val: int) -> None:
        if val <= self.min:
            self.l.append(self.min)
            self.min = val
        self.l.append(val)
        print(self.l)
        


    def pop(self) -> None:
        if self.min == self.l[-1]:
            self.l.pop()
            self.min = self.l.pop()
        else:
            self.l.pop()

    def top(self) -> int:
        return self.l[-1]

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(3)
obj.push(1)
obj.push(5)
obj.push(2)
obj.push(0)
print(obj.getMin())
obj.pop()
print(obj.getMin())
obj.pop()
print(obj.getMin())
obj.pop()
print(obj.getMin())
obj.pop()
print(obj.getMin())
