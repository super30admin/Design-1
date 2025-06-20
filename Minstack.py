# Time Complexity - O(1) - all operations can be done in constant time.
# Space Complexity - O(n). Worst case (Decending order input) can be 2x storage. We might ending storing 2x elements at most.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Implemented Min stack using a Single stack and a tracking variable.

class MinStack:

    def __init__(self):
        self.stack =[]
        self.minimum = float('inf')

    def push(self, val: int) -> None:
        if val<= self.minimum:
            self.stack.append(self.minimum)
            self.minimum = val
        self.stack.append(val)

    def pop(self) -> None:
        top = self.stack.pop()
        if top == self.minimum:
            self.minimum = self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minimum
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()