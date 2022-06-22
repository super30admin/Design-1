# Approach 1: Two Stack

# Time Complexity : O(1) for all operations
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES

class MinStack:
    
    def __init__(self):
        self.A = []
        self.M = []
        self.m = float("inf")
        self.M.append(self.m)
        
    def push(self, x):
        self.A.append(x)
        self.m = min(x,self.m)
        self.M.append(self.m)
        
    def pop(self):
        self.A.pop()
        self.M.pop()
        self.m = self.M[-1]
        
    def top(self):
        return self.A[-1]
        
    def getMin(self):
        return self.M[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()


# Approach 2: One Stack

# Time Complexity : O(1) for all operations
# Space Complexity : O(n), uses slightly less memory than Approach 1 as there's no one to one mapping of current value and current minimum, but in worst case it occupies the same space.
# Did this code successfully run on Leetcode : YES



class MinStack:
    
    def __init__(self):
        self.A = []
        self.m = float("inf")
        self.A.append(self.m)
        
    def push(self, x):
        
        if x <= self.m:
            self.A.append(self.m)
            self.m = min(x,self.m)
        self.A.append(x)
        
    def pop(self):
        if self.m == self.A.pop():
            self.m = self.A.pop()
        #else: (not needed as it already pops while checking if condition)
            #self.A.pop()
            
        
    def top(self):
        return self.A[-1]
        
    def getMin(self):
        return self.m
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()