# Time Complexity: O(1)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: All test cases passed
# Any problem you faced while coding this: No

# Your code here along with comments explaining your approach

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.array = []
        self.size = 0
        self.min = 0
        self.min_stack = []
        

    def push(self, val: int) -> None:
        
        self.array.append(val)
        self.size=self.size+1
        
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)

    def pop(self) -> None:
        
        if self.array[-1] == self.min_stack[-1]:
            self.min_stack.pop()
        
        self.array = self.array[0:self.size-1]
        self.size=self.size-1
    
        
        
    def top(self) -> int:
        return self.array[self.size-1]
        

    def getMin(self) -> int:
        if not self.min_stack:
            return None
        return self.min_stack[-1]
        
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
