class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.s = []
        self.min = []

    def push(self, x: int) -> None:
        self.s.append(x)
        if self.min == [] or x <= self.min[-1]:
            self.min.append(x)

    def pop(self) -> None:
        if self.s[-1] == self.min[-1]:
            self.min.pop()
        
        self.s.pop()

    def top(self) -> int:
        return self.s[-1]
        

    def getMin(self) -> int:
        return self.min[-1]