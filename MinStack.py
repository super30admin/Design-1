#Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :
class MinStack:

    def __init__(self):
        self.min = 2**31 - 1
        self.stack = []
        self.minStack = []
        self.minStack.append(self.min)

    def push(self, val: int) -> None:
        if val < self.min :
            self.min = val
        
        self.stack.append(val)
        self.minStack.append(self.min)

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()
        self.min = self.minStack[-1]

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.min
        


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(-3)
print('stack:',obj.stack)
print('minStack:',obj.minStack)
print(obj.getMin())
print('stack:',obj.stack)
print('minStack:',obj.minStack)
obj.pop()
print('stack:',obj.stack)
print('minStack:',obj.minStack)
print(obj.top())
print(obj.getMin())
print(obj.stack)