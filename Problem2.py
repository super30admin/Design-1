#Design minstack


''' Time Complexity : O(1) for all operations
// Space Complexity : O(2n) # n - size of minstack and mainstack
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No''

#approach - take 2 stacks. have a 1:1 mapping between main stack and minstack. minstack contains the minimum element so far.

class MinStack:
    
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minstack = []
        self.minstack.append(float('inf')) # keep a min stack to store min elements 
        

    def push(self, x: int) -> None:
        self.stack.append(x)
        self.minstack.append(min(x,self.minstack[-1])) # add the min value
        
        

    def pop(self) -> None:
        #if self.stack[-1] == self.minstack[-1]:
        self.minstack.pop()
        self.stack.pop()
        
        

    def top(self) -> int:
        return self.stack[-1]
                

    def getMin(self) -> int:
        return self.minstack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
