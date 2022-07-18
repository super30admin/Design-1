# Time Complexity : O(1) as required by the question.
# Space Complexity : O(n). I used two stacks of size n which together still takes O(n) space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class MinStack:

    def __init__(self):
        self.stack = [] # Initializing stack
        self.minStack = [] # Initializing a min stack to store the minimum values
        
    def push(self, val: int) -> None:
        if not self.stack:
            self.stack.append(val) # If the stack is empty enter val into the stack
            self.minStack.append(val) # As its the only element its the min element and we also push it to minstack
            return
        if val <= self.minStack[-1]:
            self.minStack.append(val) # If the current val is less than or same as current minimum of the stack, add it to minStack
        self.stack.append(val) # Add val to the main stack
        
    def pop(self) -> None:
        if self.minStack[-1] == self.stack[-1]:
            self.minStack.pop() # Pop from the minstack if the current top element in the stack is the minimum element
        self.stack.pop() # Pop from the stack
        
    def top(self) -> int:
        return self.stack[-1] # Return the top i.e last element of the stack

    def getMin(self) -> int:
        return self.minStack[-1] # Return the top i.e last element of the minStack


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()