
# Time Complexity : All operation O(1) 
# Space Complexity :  O(n)
# Code ran successfully run on Leetcode 
# No Issue
# I am using 1 list: stack to replicate stack functionality.The stack also keep track of minimum value
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        
        # Storing infinity
        self.min = float(inf)
        

    def push(self, val: int) -> None:
         
        # Add min to stack if value is less than current value of min
        if val <= self.min:
            self.stack.append(self.min )
            self.min = val
        self.stack.append(val)
        
        # Ignore: previous approach
        # Check if min list contains any element or not
        # If first element, directly add the val
#         if len(self.min) <= 0:
#             self.min.append(val)
        
#         # Else compare val and top of min, And append min
#         else:
#             self.min.append(min(self.min[-1], val))
        

    def pop(self) -> None:
        
        # If min and stack top is same, pop once. As we are inserting
        # min along with val in push. 
        if self.stack[-1] == self.min:
            self.stack.pop()
            
            # Update the min as previous min is popped out
            self.min = self.stack[-1]
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]
        
    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
