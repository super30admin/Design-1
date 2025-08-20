# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : not much, the minStack was fairly straight forward 


# Your code here along with comments explaining your approach
    # - Use a list as a main stack
    # - Use a list as a min stack
    # - insert value in the main and check if the min has the value, if it does compare the last value from min to the val and set th min
    # - When removing remove from both the stacks
class MinStack:

    def __init__(self):
        self.stack = [] # main stack
        self.minStack = [] # min stack
        

    def push(self, val: int) -> None:
        self.stack.append(val) # insert a val in main stack
        if not self.minStack:
            self.minStack.append(val) # insert a val in min stack
        else:
            current_min = self.minStack[-1]
            self.minStack.append(min(val, current_min)) # insert the min val to the min stack
        

    def pop(self) -> None:
        # remove from both the stack
        self.stack.pop()
        self.minStack.pop()

    def top(self) -> int:
        # return the last element from main stack
        return self.stack[-1]

    def getMin(self) -> int:
        # return the last element from min stack
        return self.minStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()