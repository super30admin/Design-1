class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.arr = [] 

    def push(self, x: int) -> None:
        
        if not self.arr:
            
            self.arr.append([x,x])
            return
            
        currMin = self.arr[-1][1]
        self.arr.append([x,min(x,currMin)])

    def pop(self) -> None:
        
        if self.arr:
            
            self.arr.pop()
        

    def top(self) -> int:
        
        if self.arr:
            
            return self.arr[-1][0]
        
        return -1

    def getMin(self) -> int:
        
        if self.arr:
            
            return self.arr[-1][1]
        
        return -1
