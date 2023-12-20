# // Time Complexity : All operations are O(1)
# // Space Complexity : O(n) since using a stack to save all the elements
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Had to look at the solution and implement this, did not realise I could have just
# used one more field to maintain minimum. Had missed updating min value when poping(incase poped value is min)


# // Your code here along with comments explaining your approach
# Approach is to use a stack, in class maintain a field called min to have the mininmum value maintained. During push, if the received
# value is mininmum, push the previous minimum first before pushing the new value and update min with new value. This is needed
# to retrieve/pop the previous min if the current value/min is popped out of stack. So handled this in push and pop
from math import inf
class MinStack:
    _min = None
    def __init__(self):
        self.stack = []     
        self.min = float(inf)   

    def push(self, val: int) -> None:
        if self.min >= val:
            self.stack.append(self.min)
            self.stack.append(val)
            self.min = val
        else:
            self.stack.append(val)
        

    def pop(self) -> None:
        popVal = self.stack.pop()
        if popVal == self.min:
            self.min = self.stack.pop()
        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.min