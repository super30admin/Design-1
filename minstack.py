## Time Complexity :O(1)
## Space Complexity :O(N)
## Did this code successfully run on Leetcode :
#yes
## Any problem you faced while coding this :
# reaching the idea to use two stacks, was thinking of using only one stack


## Your code here along with comments explaining your approach
# Taking two stacks 
class MinStack:
    def __init__(self):
        self.stack = []
        self.minStack = [] # stores only the minimum value

    def push(self, val: int) -> None:
        self.stack.append(val)
        if self.minStack:
            val = min(val,self.minStack[-1])
            self.minStack.append(val)
        
        
    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()
        
        
    
    def top(self) -> int:
        return self.stack[-1]
        
    def getMin(self) -> int:
        return self.minStack[-1]
