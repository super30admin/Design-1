class MinStack:

    def __init__(self):
        self.stack = []
        self.min = float('inf')

    def push(self, val: int) -> None:
        #If new val is less than existing min, add the previous min to stack and update min
        if self.min >= val:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)
                       

    def pop(self) -> None:
        
        #If popped element is equal to min, we pop the element and pop another element, which is the previous min and set it to min.
        x = self.stack.pop()
        if x == self.min:
            self.min = self.stack.pop()  

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min
        


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(5)
obj.push(4)
obj.push(6)
obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()
print(param_3)
print(param_4)
