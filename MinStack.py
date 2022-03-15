class MinStack:

    def __init__(self):
        self.s = []
    
    def push(self, val: int) -> None:
        if not self.s:
            self.s.append((val,val))
        else:
            prev_min = self.s[-1][1]
            if val < prev_min:
                self.s.append((val,val))
            else:
                self.s.append((val,prev_min))
                
    def pop(self) -> None:
        return self.s.pop()[0]
    
    def top(self) -> int:
        return self.s[-1][0]
    
    def getMin(self) -> int:
        return self.s[-1][1]