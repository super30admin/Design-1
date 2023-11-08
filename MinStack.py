#declared a minStack and a stack
#push: append to stack and minStack the min of the current value and the last value in minStack
#pop: pop value from both stacks
#time complexity: O(1)
#space complexity: O(n)
class MinStack:

    def __init__(self):
       self.stack = []
       self.minStack = [] 

    def push(self, val: int) -> None:
        self.stack.append(val)
        val = min(val,self.minStack[-1] if self.minStack else val)
        self.minStack.append(val)
        

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()
        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.minStack[-1]