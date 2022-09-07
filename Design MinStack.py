""""// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach"""


class MinStack:

    def __init__(self):
        self.stack = []
        self.min = float('inf')

    def push(self, val: int) -> None:
        # If new val is less than existing min, add the previous min to stack and update min
        if self.min >= val:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)

    def pop(self) -> None:

        # If popped element is equal to min, we pop the element and pop another element, which is the previous min and set it to min.
        x = self.stack.pop()
        if x == self.min:
            self.min = self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(0)
obj.push(1)
obj.push(2)
print(obj.getMin())
obj.pop()
print(obj.top())
print(obj.getMin())