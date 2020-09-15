class MinStack:

    def __init__(self):
        self.stack = []
        self.min_num = float('inf')

    def push(self, x: int) -> None:
        if x <= self.min_num:
            self.stack.append(self.min_num)
            self.min_num = x
        self.stack.append(x)
        
    def pop(self) -> None:
        if self.stack.pop() == self.min_num:
            self.min_num =self.stack.pop()

    def top(self) -> int:
        if len(self.stack)>0:
            return self.stack[-1]
        else:
            return -1

    def getMin(self) -> int:
        return self.min_num
        
 # time complexity = o(1)
 # space Complexity = o(n)
