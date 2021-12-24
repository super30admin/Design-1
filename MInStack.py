class MinStack:

    def __init__(self) -> None:
        self.stack = []
        self.minStack = []

    def push(self, val:int)-> None:
        self.stack.append(val)
        if self.minStack:
            minVal = min(val, self.minStack[-1])
        else:
            minVal = val

        self.minStack.append(minVal)

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()

    def top(self) -> None:
        return self.stack[-1]
    
    def getMin(self)->int:
        return self.minStack[-1]
