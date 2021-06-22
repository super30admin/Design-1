class MinStack:

    def __init__(self):
        self.stack=[]

    def push(self, x: int) -> None:
        if len(self.stack)==0:
            self.stack.append([x,x])
        else:
            top=self.stack[-1]
            self.stack.append([x,min(top[1],x)])
            

    def pop(self) -> None:
        if len(self.stack)>0:
            self.stack.pop()

    def top(self) -> int:
        if len(self.stack)>0:
            return self.stack[-1][0]
        return -1

    def getMin(self) -> int:
        if len(self.stack)>0:
            return self.stack[-1][1]
        return -1

     
   """
   Time complexity for all operations are 0(1)
   """
