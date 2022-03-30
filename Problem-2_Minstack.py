class MinStack:

    def __init__(self):
        self.stack = []
        
    def push(self, val: int) -> None:
        if self.top() == None:
            self.stack.append([val, val])
            return
        existing_min = self.getMin()
        min_ = val if val < existing_min else existing_min
        self.stack.append((val, min_))
        
    def pop(self) -> None:
        self.stack.pop()
        
    def top(self) -> int:
        if len(self.stack):
            return self.stack[-1][0]
        else:
            return None

    def getMin(self) -> int:
        if len(self.stack):
            return self.stack[-1][1]
        else:
            return None
        
'''Time Complexity :O(1)
// Space Complexity: O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No'''

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
