import sys
class MinStack:
    SIZE=100000

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.st=[]
        self.mst=[]
        self.minval=sys.maxsize
        
        

    def push(self, x: int) -> None:
        self.st.append(x)
        if x<self.minval:
            self.minval=x
        self.mst.append(self.minval)    
        
        

    def pop(self) -> None:
        self.st.pop()
        self.mst.pop()
        if len(self.mst)==0:
            self.minval=sys.maxsize
        else:    
            self.minval=self.mst[-1]
        

    def top(self) -> int:
        return self.st[-1]
        

    def getMin(self) -> int:
        return self.minval
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
