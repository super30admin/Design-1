class MinStack:

    def __init__(self):
        self.l=[]
        self.minstack=[]

    def push(self, val: int) -> None:
        if(len(self.l)==0):
            self.l.append(val)
            self.minstack.append(val)
        else:
            self.l.append(val)
            if (val<self.minstack[-1]):
                self.minstack.append(val)
            else:
                self.minstack.append(self.minstack[-1])
    def pop(self) -> None:
        val=self.l[-1] 
        self.l=self.l[:-1]
        self.minstack=self.minstack[:-1]
        return val        

    def top(self) -> int:
        val=self.l[-1] 
        return val        

    def getMin(self) -> int:
        return self.minstack[-1]        

    
    
    
    

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()