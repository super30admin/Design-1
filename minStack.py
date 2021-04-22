class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        
        self.inStack = []
        self.minStack = []
        self.min = float('inf')

    def push(self, val: int) -> None:
        self.inStack.append(val)
        
        if not self.minStack:
            if val<=self.min:
                self.min = val
        
        if self.min<val and self.minStack:
            self.min = self.minStack[-1]
        
        else:
            self.min = val
            
        self.minStack.append(self.min)

    def pop(self) -> None:
        
        self.inStack.pop()
        self.minStack.pop()
        
        if self.minStack:
            self.min = self.minStack[-1]
        

    def top(self) -> int:
        
        return self.inStack[-1]
        

    def getMin(self) -> int:
        return self.minStack[-1]
        

# Average time complexity is o(1)
# space complexity is 2n
# Approach is to make 2 stacks, instack and minstack. At every point, the minimum value must be on top of minstack
# 2nd stack is essentially used to keep order.

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
