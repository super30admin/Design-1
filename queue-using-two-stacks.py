from collections import deque
class MyQueue:

    def __init__(self): 
        self.stack1 = deque()
        self.stack2 = deque()
        

    def push(self, x: int) -> None:
        self.stack1.append(x)        

    def pop(self) -> int:
        if not self.stack2:
            self.peek() 
        ans= self.stack2.pop()
        return ans    

    
    def peek(self) -> int:
        if self.stack2:
             ans=self.stack2[-1]
        else:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
                ans=self.stack2[-1] 

        return ans                                                                                                                                                                                                                                                                                        

    def empty(self) -> bool:
        if len(self.stack1) == 0 and len(self.stack2) ==0:
            return True
        return False