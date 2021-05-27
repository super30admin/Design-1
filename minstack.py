class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        #stack to store values
        self.stack = []
        #stack to save minimum because if we pop, the min is lost
        self.min_stack = []
        #variable to store min 
        #initialized to inf to handle empty stack case
        self.min_val = float('inf')
        self.min_stack.append(self.min_val)
    
    def push(self, val: int) -> None:
        #find the min using min function
        self.min_val = min(self.min_val,val)
        #append val to stack
        self.stack.append(val)
        #append min_val to min_stack for every val, 1-1 correspondence
        self.min_stack.append(self.min_val)

    def pop(self) -> None:
        #since 1-1 correspondence, pop both the stack 
        self.min_stack.pop() 
        self.stack.pop()
        #reassign min value to the top of stack
        self.min_val = self.min_stack[-1]
        
    def top(self) -> int:
        #if stack is empty, return none
        if self.stack is None:
            return 
        else:
            #return top element which is the last in array so -1
            return self.stack[-1]
        
    def getMin(self) -> int:
        #min_val will maintain the min at all times
        return self.min_val

  
# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()