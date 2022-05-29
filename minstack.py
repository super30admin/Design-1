from collections import deque
class MinStack:
    
    def __init__(self):
        self.stack= deque()
        self.minstack= deque()
        
    def push(self, val: int) -> None:
        self.stack.append(val)
        if self.minstack:
            if val==self.minstack[-1]:
                self.minstack.append(val)
            else:
                min_val=min(val,self.minstack[-1])
                if min_val<self.minstack[-1]:
                    self.minstack.append(val)
            return                        
        self.minstack.append(val)
       
    def pop(self) -> None:
        popped_item=self.stack.pop()
        if popped_item==self.minstack[-1]:
            self.minstack.pop()
            return


    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        min_val=self.minstack[-1]
        return min_val