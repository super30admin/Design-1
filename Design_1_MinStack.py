# Here I created 2 variables stack and min_stack. stack to store the values in the stack and min_stack to keep the track of the record 
#of the minimum value in the stack. The Time Complexity is O(1) for all functions push(),pop(),top(),top().

class MinStack:

    def __init__(self):
        self.stack = []
        self.min_Stack = []
        

    def push(self, val: int) -> None:
        self.stack.append(val)
        val = min(val, self.min_Stack[-1] if self.min_Stack else val)
        self.min_Stack.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.min_Stack.pop()
        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.min_Stack[-1]
        


# Your MinStack object will be instantiated and called as such:
minStack = MinStack()
minStack.push(-2) #[-2]
minStack.push(0)  #[-2,0]
minStack.push(-3) #[-2,0,-3]
minStack.getMin() # return -3
minStack.pop() # pop -3
minStack.top()  # return 0
minStack.getMin()# return -2