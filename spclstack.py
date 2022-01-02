# // Time Complexity :O(1)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : no
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        
        """
        self.min_st=[]
        self.mini=inf
        

    def push(self, val: int) -> None:
        
        if val<=self.mini:
            self.min_st.append(self.mini)
            self.mini=val
        self.min_st.append(val)
        
        
        
        
        
                
            
        
            
            
        
        

    def pop(self) -> None:
        a=self.min_st.pop()
        if a==self.mini:
            self.mini=self.min_st.pop()
        
            
        
        
        

    def top(self) -> int:
        return self.min_st[-1]

    def getMin(self) -> int:
        
        return self.mini
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

