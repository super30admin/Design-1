# Time Complexity : 0(1)
# Space Complexity : 0(N) N=no. of elements in the stack
# Did this code successfully run on Leetcode : Yes. 
# Any problem you faced while coding this : Nothing specific. 


# Your code here along with comments explaining your approach

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.arr=[]
        
    def push(self, x: int) -> None:
        
        self.arr.append(x)
        
    def pop(self) -> None:
        
        return self.arr.pop(-1)
        
    def top(self) -> int:
        
        return self.arr[-1]
        
    def getMin(self) -> int:
        
        return min(self.arr)
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()