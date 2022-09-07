# // Time Complexity : O(1)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : complexity

class MinStack:

    def __init__(self):
         self.stack = []
         self.minStack = []
    def push(self, val: int) -> None:
        if not self.minStack or val<= self.minStack[-1]:
            self.minStack.append(val)
        self.stack.append(val)
        

    def pop(self) -> None:
        if self.minStack[-1] == self.stack[-1]:
           self.minStack.pop()  
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()