# Time Complexity: O(1) | space complexity : O(2*n) is also equal to O(N)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

class MinStack:
    def __init__(self):
        self.stack = []
        self.stackHash = {}
        
    def push(self, val: int) -> None:
        self.stack.append(val)
        self.stackHash[len(self.stack)-1] = min(self.stackHash.get(len(self.stack)-2, float('inf')), val)
        
    def pop(self) -> None:
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.stackHash[len(self.stack)-1]
        



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()