# Time Complexity : O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MinStack:
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min_list = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.min_list:
            self.min_list.append(val)
        else:
            self.min_list.append(min(val,self.min_list[-1])) 
        

    def pop(self) -> None:
        self.stack.pop()
        self.min_list.pop()
        
    def isEmpty(self):
        if len(self.stack) < 1:
            return True
        else:
            False

    def top(self) -> int:
        if self.isEmpty():
            return "Stack is Empty."
        return self.stack[-1]

    def getMin(self) -> int:
        if self.isEmpty():
            return "Stack is Empty."
        return self.min_list[-1]
        


obj = MinStack()
obj.push(10)
obj.push(20)
obj.push(30)
obj.push(40)
obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()
print(param_3,param_4)