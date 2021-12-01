#// Time Complexity :O(1)
#// Space Complexity :O(n)
#// Did this code successfully run on Leetcode : YES
class MinStack:

    def __init__(self):
        self.minStack=[]
        self.min=float('inf')

    def push(self, val: int) -> None:
        if(self.min>=val):
            self.minStack.append(self.min)
            self.min=val
        self.minStack.append(val)
        

    def pop(self) -> None:
        popped=self.minStack.pop()
        if(self.min==popped):
            self.min=self.minStack.pop()
        

    def top(self) -> int:
        return self.minStack[-1]
        

    def getMin(self) -> int:
        return self.min
        
