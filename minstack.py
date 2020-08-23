# Implement a Minimum stack solution.
# Push operation - Push the element and keep the value of minimum until that point.
# Pop operation - Remove the top most element from the stack.
# Top operation - Returns the value of the topmost element in the stack.
# getMin operation - Returns the minimum value in the stack at any point.
# Time complexity - O(1)  -- all operations
# Space complexity - O(n) -- where n is the number of elements (actual - 2n, also maintains minimum in the form of a tuple)
# Did this solution run on leetcode? - yes

class MinStack:
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []

    def push(self, x: int) -> None:
        if not self.stack:
            self.stack.append((x,x))
            return
        minelem = min(self.stack[-1][1], x)
        self.stack.append((x, minelem))
        
    def pop(self) -> None:
        return self.stack.pop()
        
    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        return self.stack[-1][1]
    

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

# By storing the minimum value inside the same stack -
# Initialize minimum to the integer max.
# On every push operation - check whether the incoming value is less than or equal to the current minimum. if it is, push the previous minimum with the new incoming value to the stack.
# on every pop operation, check if the current minimum value is being popped from the top of the stack. assign the next top element to the minimum, and pop it out of the stack. This way the next element will be at the top of the stack.
# Time complexity - O(1)  -- all operations
# Space complexity - O(n) -- worst case - O(2n)
# Did this solution run on leetcode? - yes
class MinStack:
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = float('inf')
        
    def push(self, x: int) -> None:
        if self.min >= x:
            self.stack.append(self.min)
            self.min = x
        self.stack.append(x)
        
    def pop(self) -> None:
        top = self.stack.pop()
        if self.min == top:
            self.min = self.stack.pop()
        
    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min
        