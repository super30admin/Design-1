# Time Complexity : O(1)
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MinStack:

    def __init__(self):
        self.main_stack = [] # To store stack elements.
        self.min_stack = [] # To store minimum elements.

    def push(self, val: int) -> None:
        self.main_stack.append(val)
        if(len(self.min_stack) == 0):
            self.min_stack.append(val)
        else:
            if (val <= self.min_stack[-1]):
                self.min_stack.append(val)

    def pop(self) -> None:
        removed_element = self.main_stack.pop()
        if(removed_element == self.min_stack[-1]):
            self.min_stack.pop()
        

    def top(self) -> int:
        return self.main_stack[-1]
        

    def getMin(self) -> int:
        return self.min_stack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
