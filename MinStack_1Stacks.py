class MinStack:
    sMin = []
    minimum = 0 
    
#MinStack Using One stack Solution

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.sMin = [] #Main Stack
        self.minimum = sys.maxsize#2147483647 #Max Value of python
        self.sMin.append(self.minimum)
    

    def push(self, x: int) -> None:
        if(x <= self.minimum):
            self.sMin.append(self.minimum)
            self.minimum = x
        self.sMin.append(x)
                
    def pop(self) -> None:
        if(self.minimum == self.sMin.pop()):
            self.minimum = self.sMin.pop()          
                          
    def top(self) -> int:
        return self.sMin[-1] # peek()

    def getMin(self) -> int:
        return self.minimum
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()