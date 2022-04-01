# Time Complexity : O(1) 
# Space Complexity : O(n) for extra stack and O(1) for all functions
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MinStack:

    def __init__(self):
        self.array = []
        self.minArray = []

    def push(self, val):
        
        self.array.append(val)
        if len(self.minArray) == 0:
            self.minArray.append(val)
        else:
            minimumVal = min(val,self.getMin())
            self.minArray.append(minimumVal)
        
    def pop(self):
        
        if len(self.array) == 0:
            return None
        
        del self.array[-1]
        del self.minArray[-1]
        
    def top(self):
        
        if len(self.array) == 0:
            return None
        
        return self.array[-1] 
        
    def getMin(self):
        
        if len(self.array) == 0:
            return None
        
        return self.minArray[-1] 


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
