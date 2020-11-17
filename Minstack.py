class MinStack:

    def __init__(self):
        self.st=[]
        self.min=[]
        self.min.append(float('inf'))

    def push(self, x: int) -> None:
        self.st.append(x)
        if x <= self.min[-1]: 
            self.min.append(x)
        
    def pop(self) -> None:
        x=self.st.pop()
        if x == self.min[-1]: 
            self.min.pop()
        return self.st

    def top(self) -> int:
        return self.st[-1]

    def getMin(self) -> int:
        return self.min[-1]