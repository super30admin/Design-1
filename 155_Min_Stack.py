# Time Complexity : O(1)
#   push:   O(1)
#   pop:    O(1)
#   top:    O(1)
#   getMin: O(1)
# 
# Space Complexity : O(n) [n is the number of elements inserted into Stack]
# 
# Did this code successfully run on Leetcode : Yes
# 
# Any problem you faced while coding this : No
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min_stack = []

    def push(self, x: int) -> None:
        self.stack.append(x)
        if len(self.min_stack) == 0:
            self.min_stack.append(x)
        else:
            if self.min_stack[-1] >= x:
                self.min_stack.append(x)

    def pop(self) -> None:
        x = self.stack.pop()
        if len(self.min_stack) > 0 and self.min_stack[-1] == x:
            self.min_stack.pop()

    def top(self) -> int:
        if self.stack:
            return self.stack[-1]
        return 0
        

    def getMin(self) -> int:
        if self.min_stack:
            return self.min_stack[-1]
        return 0
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()


"""
Testcase 1
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Testcase 2
["MinStack","push","push","push","getMin","pop","getMin"]
[[],[0],[1],[0],[],[],[]]

Testcase 3
["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
[[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
"""