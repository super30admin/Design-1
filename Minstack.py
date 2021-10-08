#Time Complexity: O(1)
#Space Complexity: O(1)
#Problem submitted successfully on leetcode
class MinStack:
# Initialize min value and push it onto the stack
    def __init__(self):
        self.min_val = 2**31
        self.stack = []
        self.stack.append(self.min_val)
#If the value to be pushed is less than min_val, push min_val and then given value and update new min value
    def push(self, val: int) -> None:
        if (self.min_val >= val):
            self.stack.append(self.min_val)
            self.min_val = val
        self.stack.append(val)
        
#If the popped elemet was minimum, pop and update the min value
    def pop(self) -> None:
        temp = self.stack.pop()
        if temp == self.min_val:
            self.min_val = self.stack.pop()
        
# Return the top of stack
    def top(self) -> int:
        return self.stack[-1]
        
#Return the minimum value
    def getMin(self) -> int:
        return self.min_val
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()