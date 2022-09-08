class MinStack:
    def __init__(self):
        self.stack = []

    def push(self, val: int) -> None:
        if not self.stack:
            self.stack.append([val, val])
        else:
            self.stack.append([val, min(val, self.stack[-1][1])])
            
    def pop(self) -> None:
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        return self.stack[-1][1]

if __name__ == '__main__':   
    ms = MinStack()
    ms.push(4)
    ms.push(5)
    ms.push(3)
    ms.pop()
    print(ms.getMin())