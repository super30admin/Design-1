#Time Complexity : O(1) for all functions
#Space Complexity :O(n^2)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :NA
class MinStack:

    def __init__(self):
        
        self.stack = [] #initialize stack
        self.minstack = [] # initialise stack for min value at each point

    def push(self, val: int) -> None:
        self.stack.append(val) #push val onto stack
        if not self.minstack:# push val into minstack
            self.minstack.append(val)
        else: # push minimum of current step into minstack
            self.minstack.append(min(val,self.minstack[-1] ))
 
    def pop(self) -> None:
         if self.stack:
            self.minstack.pop() # pop minstack to current minimu val
            return self.stack.pop() #pop stack val
         else: 
            return None
 
    def top(self) -> int:
        return self.stack[-1] if self.stack else  None #return top of stack
    def getMin(self) -> int:
        return self.minstack[-1] if self.stack else  None # return top of min stack as current min value
        


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(4)
obj.push(3)
obj.push(0)
obj.push(10)
obj.push(-2)
obj.push(25)
obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()