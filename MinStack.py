# Time Complexity : O(1)
# Space Complexity : O(n); as minStack is additionally used
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : coming up with optimized approach


# Your code here along with comments explaining your approach
'''
Approach:
we create a stack which does the basic operations push, pop and top. In addition to that we have minStack which holds the minimum value until that range.
In the push function:
The value is pushed onto the top in the stack
In case the minStack is empty or the value to be pushed to less than equal to top of it, then the new value is pushed.
In the pop function:
The value on the top is removed from the stack
If the value on the top of stack and minstack are equal, then pop the top value from minStack

'''

from collections import deque
class MinStack:

    def __init__(self):
        self.stack = deque()
        self.minStack = deque()
        

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.minStack or val <= self.minStack[-1]:
            self.minStack.append(val)
        

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
