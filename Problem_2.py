# Time Complexity : O(1) for all operations
# Space Complexity : O(2N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# We are using a double stack approach one which will act as our primary stack and the other which will only update when a minimum value is introduce or removed this allows use to keep the stacks in sync so we can utilize any operation in O(1) time
class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        self.stack.append(val) # when we append we also check to see if our min stack is empty or if the value we appended is smaller then the current val in our min stack if so append the val to min stack
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)
    def pop(self) -> None:
        if self.stack:
            if self.stack[-1] == self.min_stack[-1]: # if the top index in our min stack is equal to the top val in our stack we remove both otherwise we only remove from the main stack
                self.min_stack.pop()
            self.stack.pop()
        else:
            return None
    def top(self) -> int:
        if self.stack:
            return self.stack[-1] # return the last element in our list which is the first element in our stack
        else:
            return None

    def getMin(self) -> int:
        if self.min_stack:
            return self.min_stack[-1] # returns lowest val in our minstack which will be the last element in the list 
        else:
            return None

