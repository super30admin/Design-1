class MinStack:

    def __init__(self):
        self.list = []
        

    def push(self, val: int) -> None:
        self.list.append(val)
        

    def pop(self) -> None:
        int = self.list.pop()
        print(int)
        

    def top(self) -> int:
        return self.list[-1]
        

    def getMin(self) -> int:
        return min(self.list or [-1])
        

