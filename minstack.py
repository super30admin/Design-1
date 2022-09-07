'''
Time Complexity: O(1)
Space Complexity: O(n)
'''
import math
class MinStack:
    def __init__(self):
        self.stack = []
        self.topval = None
        self.min = math.inf
        
    def push(self, val: int) -> None:
        if(self.min>=val):
            self.stack.append(self.min)
            self.min = val
            if(not self.topval):
                self.topval = 0
            else:
                self.topval += 1 
        self.stack.append(val)
        self.topval +=1
        
    def pop(self) -> None:
        val = self.stack.pop()
        self.topval -= 1
        if(val == self.min):
            self.min = self.stack.pop()
            self.topval -= 1
        
    def top(self) -> int:
        return self.stack[self.topval]

    def getMin(self) -> int:
        return self.min
        
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()