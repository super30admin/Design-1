## Time Complexity o(1)
## Worst case Time Complexity = o(N)
## Leet code passed 
## Minstack Class
import math
class MinStack:

    def __init__(self):
        ## created a variable min initiated with 
        self.min = math.inf 
        ## created a empty stack 
        self.stack = [] 
        
        
    ## if value is less than or equal to the min then push the min value inside the stack and update min value 
    ## with new pushed value and then push the new value to the stack 
    ## = because the case like (4,4)
    def push(self, val: int) -> None:
        if val <= self.min:
            self.stack.append(self.min)
            self.min = val
   
        self.stack.append(val)
        
        
    ## if pop == min then pop once more and assign that value to min
    def pop(self) -> None:
        
        if self.min  == self.stack.pop():
            print(self.stack)
            self.min = self.stack.pop()
            print(self.min )


    def top(self) -> int:
        return  self.stack[-1]
        

    def getMin(self) -> int:
    
        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

