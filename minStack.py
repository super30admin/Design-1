class MinStack:

    def __init__(self):
        self.myStack = []
        
        

    def push(self, val: int) -> None:
       if len(self.myStack) == 0:
           self.myStack.append((val,val))
       else:
           self.myStack.append((val,min(self.myStack[-1][1],val)))
          
               
        

    def pop(self) -> None:
        if self.myStack:
            self.myStack.pop()

        

    def top(self) -> int:
        if self.myStack:
            return self.myStack[-1][0]
        return 0
        

    def getMin(self) -> int:
        if self.myStack:
            return self.myStack[-1][1]
        return 0