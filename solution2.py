# Time Complexity : push -> O(1) for all operations
# Space Complexity : push -> O(n) where n is number of elements in stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class MinStack:

    def __init__(self):
        self.stack=[]
        #maintain a min value always and add as tuple to stack
        self.minval=float('inf')
        

    def push(self, val: int) -> None:
        if not self.stack:
            self.stack.append((val,val))
        else:
            self.minval=min(val,self.stack[-1][1])
            self.stack.append((val,self.minval))
        

    def pop(self) -> None:
        self.stack.pop()
        
        

    def top(self) -> int:
        return self.stack[-1][0]
        

    def getMin(self) -> int:
        return self.stack[-1][1]