class MinStack:

    def __init__(self):
        self.stack=[]

    def push(self, val: int) -> None:
        mini=self.getMin()
        if mini is None or val<mini :
            self.stack.append((val,val)) 
        else:
            self.stack.append((val,mini))
        # print(self.stack)

    def pop(self) -> None:
        del(self.stack[-1])

    def top(self) -> int:
        l=len(self.stack)
        return self.stack[l-1][0]
        

    def getMin(self) -> int:
        if len(self.stack)==0:
            return None
        return self.stack[-1][-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()