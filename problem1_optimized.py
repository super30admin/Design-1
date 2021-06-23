#Time complexity - O(1) for all operations
#space complexity - O(n) #worst case one stack used
class MinStack:

    def __init__(self):
        self.m_s=[] #main stack to store all the elements
        self.min_val=float('inf')
        
        

    def push(self, val: int) -> None:
        #append element into main stack
        if self.m_s:
            if self.min_val>=val:
                self.m_s.append(self.min_val)
                self.m_s.append(val)
                self.min_val=val
                
            else:
                self.m_s.append(val)
        else:
            self.m_s.append(val)
            self.min_val=val
           
        
    
    def pop(self) -> None:
        if self.m_s:
            top_v=self.m_s.pop()
            if self.min_val==top_v:
                self.min_val=self.m_s.pop()
            else:
                self.m_s.pop()
            
        

    def top(self) -> int:
        #gets the top element of the main stack.
        return self.m_s[-1]
        

    def getMin(self) -> int:
        #retrieves the minimum element in the  aux stack.
        return self.min_val
    
    def isEmpty(self):
        return self.m_s==[]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
