# Time Complexity: O(1) All operations take constant time and no traversal is required
# Space Complexity: O(N), worst case 2N if the input is given in decreasing order, N being the number of elements in stack

class MinStack:

    def __init__(self):
        self.min = float("inf")
        self.stack = []
        

    def push(self, val: int) -> None:
        if val <= self.min:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)
        

    def pop(self) -> None:
        popedVal = self.stack.pop()
        if popedVal == self.min:
            self.min = self.stack.pop()
        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.min
        


obj = MinStack()
obj.push(5)
print(obj.getMin())
obj.push(9)
print(obj.getMin())
obj.push(4)
print(obj.getMin())
obj.pop()
print(obj.getMin())
param_3 = obj.top()
print(param_3)
