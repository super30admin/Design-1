class MinStack:

    def __init__(self):
        self.st=[]
        self.minSt=[]
        self.min=float('inf')
        self.minSt.append(self.min) 
        

    def push(self, val: int) -> None:
        self.min = min(val, self.min)
        self.st.append(val)
        self.minSt.append(self.min)
        

    def pop(self) -> None:
        self.st.pop()
        self.minSt.pop()
        self.min=self.minSt[-1]
        

    def top(self) -> int:
        return self.st[-1]
        

    def getMin(self) -> int:
        return self.min
        

