"""
 Time Complexity : O(1)
 Space Complexity : O(n)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No
 Your code here along with comments explaining your approach
"""
class MinStack:

    def __init__(self):
        self.data = []
        

    def push(self, val: int) -> None:
        if not self.data:
            self.data.append((val,val))
            return
        
        #last tuple of list (-1) and tuple's second element [1]
        min_val = self.data[-1][1]
        self.data.append((val, min(val,min_val)))

    def pop(self) -> None:
        if not self.data:
            return
        else:
            self.data.pop()
        
        

    def top(self) -> int:
        if not self.data:
            return None
        else:
            return self.data[-1][0]
        

    def getMin(self) -> int:
        if not self.data:
            return 
        else:
            return self.data[-1][1]
      
        
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()