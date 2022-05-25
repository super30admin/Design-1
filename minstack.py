# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
# added a tuple in the list which is for minimum value.
# when ever push function is called it checks the 2nd element and adds the minimum element b/w two elements
# for getting minimum value return the last element in the last tuple in the list
import sys


class MinStack:
    def __init__(self):
        self.stack = []
        self.min = sys.maxsize
    # def push(self, val: int) -> None:
    #     if not self.stack:
    #         self.stack.append((val, val))
    #     else:
    #         self.stack.append((val, min(self.stack[-1][-1], val)))
    #
    # def pop(self) -> None:
    #     self.stack.pop()
    #
    # def top(self) -> int:
    #     return self.stack[-1][0]
    #
    # def getMin(self) -> int:
    #     return self.stack[-1][-1]

    def push(self, val):
        if not self.stack:
            self.stack.append(val)
            self.min = val
        else:
            if val <= self.min:
                self.stack.append(self.min)
                self.stack.append(val)
                self.min = val
            else:
                self.stack.append(val)

    def pop(self):
        x = self.stack.pop()
        if x == self.min:
            self.min = self.stack.pop()

    def top(self):
        return self.stack[-1]

    def getMin(self):
        return self.min


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(-3)
print(obj.getMin())
obj.pop()
print(obj.top())
print(obj.getMin())
