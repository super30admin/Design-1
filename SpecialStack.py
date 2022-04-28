#Timecomplexity:O(1)
#Spacecomplexity:O(n)
class MinStack:

    def __init__(self):
        self.lst = []
        self.minArray = []
        
    def push(self, val: int) -> None:
        self.lst.append(val)
        if self.minArray:
            minm = min(self.minArray[-1],val)
            self.minArray.append(minm)
        else:
            self.minArray.append(val)

    def pop(self) -> None:
        self.lst.pop()
        self.minArray.pop()
        
    def top(self) -> int:
        return self.lst[-1]
        
    def getMin(self) -> int:
        return self.minArray[-1]