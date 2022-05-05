#TimeComplexity: Push Pop Top GetMin all in O(1)
#SpaceComplexity: O(N)+O(N) =O(N)
#It successfully runs on leetcode

class MinStack:
    mini=float('inf')
  
    def __init__(self):
        self.stack=[]
        self.minstack=[]
        self.minstack.append(self.mini)
    
    def push(self, val: int) -> None:
        self.stack.append(val)
        self.mini=min(val,self.mini)
        self.minstack.append(self.mini)
             
    def pop(self) -> None:
        self.stack.pop()
        self.minstack.pop()
        self.mini = self.minstack[-1]
        
    def top(self) -> int:
        return self.stack[-1]
        
    def getMin(self) -> int:
        return self.mini