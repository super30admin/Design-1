# Time Complexity - O(1)
# Space Complexity - O(1)

class MinStack:

    def __init__(self):
        self.main_stack = []
        self.min_stack = []
        
    def push(self, val: int) -> None:
        # always append new elements to the main stack
        self.main_stack.append(val)
        if(len(self.min_stack) == 0):
            self.min_stack.append(val)
        else:
            # if the new element is the new minimum, append it to main stack
            if (val <= self.min_stack[-1]):
                self.min_stack.append(val)

    def pop(self) -> None:
        # check if removed element equals to current minimum
        removed_element = self.main_stack.pop()
        if(removed_element == self.min_stack[-1]):
            self.min_stack.pop()
        

    def top(self) -> int:
        # return last element from main stack
        return self.main_stack[-1]
        

    def getMin(self) -> int:
        # return last element from min stack
        return self.min_stack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()