class MinStack:

    def __init__(self):
        self.min_stack = []
        #self.min = 2**32
        

    def push(self, val: int) -> None:
        # if  self.min:
        #     print(self.min)
        #     min_current = min(val,self.min)
        # else :
        #     min_current  = val
        
        if self.min_stack:
            min_current = min(val,self.min_stack[-1][1])
            self.min_stack.append((val,min_current))
            # self.min = min_current
        else :
            self.min_stack.append((val,val))
            

    def pop(self) -> None:
        val = self.min_stack[-1]
        self.min_stack.pop()
    
        
        

    def top(self) -> int:
        return self.min_stack[-1][0]
        

    def getMin(self) -> int:
        return self.min_stack[-1][1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()