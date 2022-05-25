class MinStack:
    mini=sys.maxsize
    li=[]

    def __init__(self):
        self.li=[]
        

    def push(self, val: int) -> None:
        if val<=self.mini:
            self.li.append(self.mini)
            self.li.append(val)
            self.mini=val
        else:
            self.li.append(val)
        
        

    def pop(self) -> None:
        if self.li:
            if self.mini==self.li.pop(-1):

                self.mini=self.li.pop(-1)
            else:
                pass
            
        

    def top(self) -> int:
        return self.li[-1]
        

    def getMin(self) -> int:
        return self.mini
        
