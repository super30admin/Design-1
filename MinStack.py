'''
Initializing a stack to take tuples as the input with two values: 
    (the element to be pushed, the recent minimum)
All the operations are performed on it with O(1) since we keep track of 
    the minimum value at every level the element is getting pushed

TC: push - O(1), pop - O(1), top - O(1), getMin - O(1)
SC: O(n) where n is the number of elements pushed into the stack
'''
class MinStack:
    def __init__(self):
        self.stack = []       

    def push(self, val: int) -> None:
        if not self.stack:
            self.stack.append((val,val))
        else:
            if self.stack[-1][1] < val:
                self.stack.append((val,self.stack[-1][1])) 
            else:
                self.stack.append((val,val))

    def pop(self) -> None:
        if self.stack:
            self.stack.pop()

    def top(self) -> int:
        return self.stack[-1][0]      

    def getMin(self) -> int:
        return self.stack[-1][1]

# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(8)
obj.push(7)
obj.push(1)
obj.push(2)
obj.push(3)
obj.push(5)
obj.push(4)
obj.push(3)
obj.pop()
param_3 = obj.top()
print(f"Top of the stack is: {param_3}")
param_4 = obj.getMin()
print(f"Min of the stack is: {param_4}")