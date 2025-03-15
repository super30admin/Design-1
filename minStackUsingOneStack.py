# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I didn't face any problem while coding this.


# Your code here along with comments explaining your approach

class MinStack:

    def __init__(self):
        # initializing stack
        self.stack = []
        # initializing minimum value
        self.min = float('inf')

    def push(self, val: int) -> None:
        # if the value is less than or equal to the minimum value, append the minimum value to the stack before appending the value
        # and update the minimum value
        if val <= self.min:
            self.stack.append(self.min)
            self.stack.append(val)
            self.min = val
        # else, append the value to the stack
        else:
            self.stack.append(val)

    def pop(self) -> None:
        ele = self.stack.pop()
        # if the popped value is equal to the minimum value, update the minimum value to the next value in the stack
        if ele == self.min:
            self.min = self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        # return the minimum value
        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()