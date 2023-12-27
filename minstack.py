#Time Complexity :O(1)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class MinStack:
    #Here we are having 2 list, one for storing all values and another for the minimum values.
    def __init__(self):
        self.stack = []
        self.minStack = []

    #Adding the value onto the main stack . 
    #If the new value is not the minimum, repeat the current minimum in the minStack.
    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.minStack or val <= self.minStack[-1]:
            self.minStack.append(val)
        else:
            self.minStack.append(self.minStack[-1])

    #Remove the top element from both stacks, if the stack is not empty
    def pop(self) -> None:
        if self.stack:
            self.stack.pop()
            self.minStack.pop()

    # Return the top element from the main stack.
    def top(self) -> int:
        if self.stack:
            return self.stack[-1]
        raise IndexError("Stack is empty")

    # Return the current minimum value from the minstack which is the top element.
    def getMin(self) -> int:
        if self.minStack:
            return self.minStack[-1]
        raise IndexError("MinStack is empty")


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()