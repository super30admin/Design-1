#Time Complexity: O(1)
#Space Complexity:O(n) due to 2 stacks
# This code is tested on leetcode

class MinStack:
#implementing the problem using 2 stack approach
    def __init__(self):
        self.stack = [] # defining the stack.
        self.min = [] #  to calculate and maintain the minimum value.

    def push(self, val: int) -> None:
        self.stack.append(val) # push the value in then newer stack
        if not self.min or val <= self.min[-1]:
            self.min.append(val)# operation to keep minimum value on top.

    def pop(self) -> None:
        if not self.stack: # if the element is not present inside the stack
            return None
        value = self.stack.pop() # removing the element from the main stack
        if value == self.min[-1]:
            self.min.pop()
    def top(self) -> int:# returning the topmost element 
        if not self.stack:
            return None
        return self.stack[-1]

    def getMin(self) -> int: # function to return the minimum element inside a stack
        if not self.min:
            return None
        return self.min[-1] 


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()