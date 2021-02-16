class minstack:
    def __init__(self):
        self.mystack=[]
        self.min=100000
        
    def push(self,num):
        self.mystack.append(num)
        if num<self.min:
            self.min=num
    
    def pop(self):
        return self.mytack.pop()
    
    def min_item(self):
        return self.min
        
    def is_Empty(self):
        if len(self.mystack)==0:
            return True
        else:
            return False
    
   

min_stack=minstack()
min_stack.push(10)
min_stack.push(20)
min_stack.push(7)
min_stack.push(8)
min_stack.min_item()
