class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stk = []
        self.min = []
        

    def push(self, val: int) -> None:
        if not self.stk:
            self.stk.append(val)
            self.min.append(val)
        else:
            self.stk.append(val)
            
        if val <= self.min[-1]: # used <= as there can be more than one instance of the same min in the stack
            self.min.append(val)
        
            
        
        

    def pop(self) -> None:
        if self.stk[-1] == self.min[-1]:
            self.stk.pop()
            self.min.pop()
        else :
            self.stk.pop() # got incorrect when not used the else condition, as it was running everytime
        
        

    def top(self) -> int:
        return self.stk[-1]
        

    def getMin(self) -> int:
        return self.min[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()