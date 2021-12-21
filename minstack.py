"""
// Time Complexity : push: O1, getmin:ON using stack array here
// Space Complexity : ON, all input data
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

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
obj.push(1)
obj.push(5)
obj.push(4)
obj.push(5)
obj.push(4)
obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()
print(param_4)
print(obj.stack)