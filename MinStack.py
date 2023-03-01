class MinStack:

    def __init__(self):
        self.minStack = [] 
        self.numbers = [] 

    def push(self, val: int) -> None:
        self.numbers.append(val)
        if self.minStack:
            val = min(val, self.minStack[-1])
        else:
            val = val
        
        self.minStack.append(val)

    def pop(self) -> None:
        self.numbers.pop()
        self.minStack.pop()

    def top(self) -> int:
        return self.numbers[-1]

    def getMin(self) -> int:
        return self.minStack[-1]


