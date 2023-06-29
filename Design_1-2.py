class MinStack:

    def __init__(self):
        self.stack=[]
        self.min=[]
        self.size=0
        

    def push(self, val: int) -> None:
        if self.size==0:
            self.min.append(val)
        else:
            if val <= self.min[-1]:
                self.min.append(val)
        self.stack.append(val)
        self.size+=1
       
    def pop(self) -> None:
        tmp=self.stack.pop()
        self.size-=1
        if tmp==self.min[-1]:
            self.min.pop()
        

    def top(self) -> int:
        return self.stack[-1]
        
    def getMin(self) -> int:
        return self.min[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()