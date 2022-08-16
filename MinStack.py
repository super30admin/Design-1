class MinStack:

    def __init__(self):
        self.valstack = []
        self.minstack = []
        
        
        
    def push(self, val: int) -> None:
        self.valstack.append(val)
        if not self.minstack or self.minstack[-1]> val:
            self.minstack.append(val)
        else:
            self.minstack.append(self.minstack[-1])
            

    def pop(self) -> None:
        self.valstack.pop()
        self.minstack.pop()
        
        
        
        

    def top(self) -> int:
        return self.valstack[-1]

    def getMin(self) -> int:
        return self.minstack[-1]
        

