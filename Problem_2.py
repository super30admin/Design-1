# // Time Complexity : O(1)
# // Space Complexity : O(n)
    
# The approach here is to use two arrays, one to keep the elements and another to keep track of min,
# we will only keep the smallest element in minStack at end, and remove it when that same element is removed from self.stack

class MinStack:

    def __init__(self):
        
        self.stack = []
        self.minStack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if(len(self.minStack) == 0):
            self.minStack.append(val)
        else:
            if(self.minStack[-1] >= val):
                self.minStack.append(val)


    def pop(self) -> None:
        if(len(self.stack) > 0):
            if (self.stack[-1] == self.minStack[-1]):
                self.minStack.pop(-1)    
            return self.stack.pop(-1)
        
        
    def top(self) -> int:
        if(len(self.stack) > 0):
            return self.stack[-1]

    def getMin(self) -> int:
        if(len(self.minStack) > 0):
            return self.minStack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()