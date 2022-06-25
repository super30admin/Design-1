# Time Complexity : 101
#  Space Complexity : 17.9
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A


#  Your code here along with comments explaining your approach

class MinStack:
    #Here I have used two stack one to maintain the minimum element and other is normal stack
    def __init__(self):
        self.stack = []
        self.minStack = []
    
    #I used the append feature of list in python to push elements and added check for minStack for minimum values
    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.minStack or self.minStack[-1] >= val: 
            self.minStack.append(val)
            
    #Here I used the pop feature of python which removes the last element entered and removed the same element
    #from minStack as well to maintain parity
    def pop(self) -> None:
        if self.stack:
            val = self.stack.pop()
        if self.minStack and val == self.minStack[-1]:
            self.minStack.pop()

    #Here the [-1] is used to return the top element from both top and getMin with there respective stacks
    def top(self) -> int:
        if self.stack:
            return self.stack[-1]

    def getMin(self) -> int:
        if self.stack:
            return self.minStack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()