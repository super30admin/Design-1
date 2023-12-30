# class MinStack:

#     def __init__(self):
#         self.minStack = []
        

#     def push(self, val: int) -> None:
#         self.minStack += [val]
        

#     def pop(self) -> None:
#         self.minStack = self.minStack[:-1]
        

#     def top(self) -> int:
#         return self.minStack[-1]
        

#     def getMin(self) -> int:
#         minVal = 2**31-1
#         for i in self.minStack:
#             if i < minVal:
#                 minVal = i
#         return minVal

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()


class MinStack:

    def __init__(self):
        self.Stack = []
        self.minStack = []    

    def push(self, val: int) -> None:
        self.Stack.append(val)
        if not self.minStack or val <= self.minStack[-1]:
            self.minStack.append(val)
        
    def pop(self) -> None:
        if self.Stack:
            popped_value = self.Stack.pop()
            if popped_value == self.minStack[-1]:
                self.minStack.pop()   

    def top(self) -> int:
        return self.Stack[-1]
        
    def getMin(self) -> int:
        return self.minStack[-1]