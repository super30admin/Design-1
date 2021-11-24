class MinStack:
    def __init__(self):
        self.s = []
        self.mins = []


    def push(self, val: int) -> None:
        self.s.append(val)
        if self.mins:
             val = min(val, self.mins[-1])
        else:
            val = val
            
        # val = min(val, self.mins[-1] if self.mins else val)
        self.mins.append(val)

    def pop(self) -> None:
        self.s.pop()
        self.mins.pop()
        

    def top(self) -> int:
        return self.s[-1]

    def getMin(self) -> int:
        return self.mins[-1]
