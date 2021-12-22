"""
// Time Complexity : push: O1, getmin:ON using stack array here
// Space Complexity : ON, all input data
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//push pop top must be O1
Use 2 stacks, in house stack fxn allowed
one stak to keep track of min, as pop occurs
"""
class MinStack:

    def __init__(self):
        self.stack = []

    def push(self, val: int) -> None:
        self.stack.append(val)

    def pop(self) -> None:
        length = len(self.stack )-1
        if self.stack == []:
            print("stack is empty")
        else:
            self.stack.remove(self.stack[length])
 
        

    def top(self) -> int:
        length = len(self.stack)-1
        return self.stack[length]
        

    def getMin(self) -> int:
        x = 0
        smallest = 100000
        for y in self.stack:
            if y < smallest:
                smallest = y
        return smallest
            





# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(6)
obj.push(5)
obj.push(4)
obj.push(5)
obj.push(1)
obj.pop()

param_3 = obj.top()
param_4 = obj.getMin()
print(param_4)
print(obj.stack)
obj.pop()
obj.push(1)
print(param_4)
print(obj.stack)
obj.push(1)

print(obj.stack)
print(obj.getMin())
