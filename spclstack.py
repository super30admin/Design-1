# // Time Complexity :O(1)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : Yes,got accepted
# // Any problem you faced while coding this : Got the solution too fast, but since it is a medium level qn I think there is some mistake


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        
        """
        self.arr=[]
        self.min=0
        

    def push(self, val: int) -> None:
        
        self.arr.append(val)
        
                
            
        
            
            
        
        

    def pop(self) -> None:
        
        self.arr.pop()
        
        
        

    def top(self) -> int:
        a=self.arr[-1]
        return a
        

    def getMin(self) -> int:
        
        return min(self.arr)
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()