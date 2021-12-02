class MinStack:

    def __init__(self):
        self.array=[]
        self.minarray=[]
        self.minimum=math.inf

    def push(self, val: int) -> None:
        self.val=val
        if val<self.minimum:
            self.minimum=val
        self.array.append(val)
        self.minarray.append(self.minimum)
        
    def pop(self) -> None:
        self.array.pop()
        self.minarray.pop()
        if len(self.minarray)!=0:
            self.minimum=self.minarray[-1]
        else:
            self.minimum=math.inf

    def top(self) -> int:
        return self.array[-1]
        
    def getMin(self) -> int:
        return self.minimum
        
