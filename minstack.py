class minstack:
    def __init__(self):
        self.mystack=[]
        self.min=sys.maxsize
        
    def push(self,num):
        if num<=self.min:
            self.mystack.append(self.min)
            self.min=num
        self.mystack.append(num)
            
    
    def pop(self):
        popped=self.mystack.pop()
        if popped==self.min:
            self.min=self.mystack.pop()
    
    def min_item(self):
        return self.min
        
    def peek(self):
        return self.mystack[-1]
    
min_stack=minstack()
min_stack.push(10)
min_stack.push(20)
min_stack.push(7)
min_stack.push(8)
min_stack.min_item()
min_stack.pop()
min_stack.pop()
min_stack.min_item()
        
        
        
        
        
        
        
