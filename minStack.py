class MinStack:

    def __init__(self):
        self.st = []
        self.min = float('inf')
        

    def push(self, val: int) -> None:
        if val<=self.min:
            self.st.append(self.min)
            self.st.append(val)
            self.min = val
        else:
            self.st.append(val)
        
        

    def pop(self) -> None:
        val = self.st.pop()
        if val==self.min:
            val = self.st.pop()
            self.min = val
        
        

    def top(self) -> int:
        return self.st[-1]
        

    def getMin(self) -> int:
        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()