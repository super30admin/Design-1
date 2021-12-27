# Time Complexity : All operation O(1) 
 # Space Complexity : Additional space for storing min in a list O(n)
 # Code ran successfully run on Leetcode 
 # No Issue
class MinStack:

    def __init__(self):
        self.stack = []
        self.min = []
        

    def push(self, val: int) -> None:
        self.stack.append(val)

         # Check if min list contains any element or not
         # If first element, directly add the val
        if len(self.min) <= 0:
             self.min.append(val)

         # Else compare val and top of min, And append min
        else:
             self.min.append(min(self.min[-1], val))
        

    def pop(self) -> None:
        self.stack.pop()
        self.min.pop()
        

    def top(self) -> int:
        return self.stack[-1]
            
        

    def getMin(self) -> int:
        return self.min[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()