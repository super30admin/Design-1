# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I didn't face any problem while coding this.


# Your code here along with comments explaining your approach

class MinStack:

    def __init__(self):
        # initializing stack and minStack
        self.stack = []
        self.minStack = []
        # initializing minimum value
        self.minimum = float('inf')

    def push(self, val: int) -> None:
        # append the value to the stack
        self.stack.append(val)
        # if the value is less than or equal to the minimum value, append the minimum value to the minStack
        # and update the minimum value
        if val <= self.minimum:
            self.minStack.append(self.minimum)
            self.minimum = val

    def pop(self) -> None:
        ele = self.stack.pop()
        # if the popped value is equal to the minimum value, update the minimum value to the next value in the minStack
        if ele == self.minimum:
            self.minimum = self.minStack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        # return the minimum value
        return self.minimum




# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()