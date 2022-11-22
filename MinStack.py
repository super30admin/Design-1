class MinStack:
    
    """
    push method - time complexity - O(1) , space complexity - O(n)
    pop method - time complexity - O(1)
    top method - time complexity - O(1)
    getMin method - time complexity - O(1)   
    """

    def __init__(self):
        self.stack = []
        self.min_stack = []
        self.size = 0
        

    def push(self, val: int) -> None:
        self.stack.append(val)
        # store the min value in stack in that element in min_stack
        if self.size > 0 and self.min_stack[self.size-1] < val:
            self.min_stack.append(self.min_stack[self.size-1])
        else:
            self.min_stack.append(val)
        self.size += 1
            
            
        
        

    def pop(self) -> None:
        val = self.stack[self.size-1]
        self.stack = self.stack[:-1]
        self.min_stack = self.min_stack[:-1]
        self.size -= 1
        
        
        

    def top(self) -> int:
        return self.stack[self.size-1]
        
        

    def getMin(self) -> int:
        return self.min_stack[self.size-1]
        
