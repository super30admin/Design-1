#Time Complexity : O(1)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no 
#used 2 stacks one for elments other for storing previous min value
class MinStack:

    def __init__(self):
        self.estack=[]
        self.pstack=[]
        self.cmin = float('inf')

    def push(self, val: int) -> None:
        self.estack.append(val)
        if val <= self.cmin:
            self.pstack.append(self.cmin)
            self.cmin = val 


    def pop(self) -> None:
        if not self.estack:
            return
        pop_ele = self.estack.pop()
        if pop_ele == self.cmin:
            self.cmin = self.pstack.pop() 

    def top(self) -> int:
        return self.estack[-1] if self.estack else None
 

    def getMin(self) -> int:
        if not self.estack:
            return None
        return self.cmin
        

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()