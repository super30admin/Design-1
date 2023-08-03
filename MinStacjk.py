class MinStack:

    def __init__(self):
        self.min = 9999999999
        self.st = []
        self.minst = [self.min]

    def push(self, val: int) -> None:
        self.st.append(val)
        self.min = min(val,self.min)
        self.minst.append(self.min)
        

    def pop(self) -> None:
        self.st.pop()
        self.minst.pop()
        self.min = self.minst[-1]

        

    def top(self) -> int:
        return self.st[-1]

    def getMin(self) -> int:
        return self.min
        