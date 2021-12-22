# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : No because while running the code it did accept but while submitting it said a runtime error on line25 in my code below.
# Any problem you faced while coding this : When leetcode wasnt taking my solution i tried to figure out what is going wrong with the code but I could not do it.

# Your code here along with comments explaining your approach

class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []
        self.minValue = None

    def push(self, val: int) -> None:
        # append the value on stack
        self.stack.append(val)

        # setting minimum value in a variable
        if self.minValue == None:
            self.minValue = val

        # if val is less than the minimum value update minimum value as val
        else:
            if val < self.minValue:
                self.minValue = val

        # append minimum value for each element in the stack
        self.minStack.append(self.minValue)

    def pop(self) -> None:
        # popping one element from both the stacks
        self.stack.pop()
        self.minStack.pop()
        self.minValue = self.minStack

    def top(self) -> int:
        # returns the topmost element in the stack
        return self.stack[-1]

    def getMin(self) -> int:
        # returns the topmost element in the minStack
        return self.minStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
