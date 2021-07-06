# Time Complexity : O(1)
#   push:   O(1)
#   pop:    O(1)
#   top:    O(1)
#   getMin: O(1)
# 
# Space Complexity : O(n) [n is the number of elements inserted into Stack]
# 
# Did this code successfully run on Leetcode : Yes
# 
# Any problem you faced while coding this : No
#
# Problem Approach
# 1. The min_stack stores the values only if it is the current minimum value or was previously a minimum value  in the stack
# 2. The top of min_stack houses the minimum value in the stack
# 3. The stack stores all the values pushed and is used to get the top of stack
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min_stack = []

    def push(self, x: int) -> None:
        self.stack.append(x) # The value is pushed on to stack
        if len(self.min_stack) == 0: # min_stack is empty, so the value pushed is the minimum value
            self.min_stack.append(x)
        else:
            if self.min_stack[-1] >= x: # push the value to min_stack if it is less than its top
                self.min_stack.append(x)

    def pop(self) -> None:
        x = self.stack.pop()
        if len(self.min_stack) > 0 and self.min_stack[-1] == x: # if the popped value is same as the minumum value, then we pop from min_stack also to restore the previous minimum value
            self.min_stack.pop()

    def top(self) -> int:
        """
        Return top of stack if it exist, otherwise return 0(Stack is empty)
        """
        if self.stack:
            return self.stack[-1]
        return 0
        

    def getMin(self) -> int:
        """
        Return top of min_stack if it exist, otherwise return 0(Stack is empty)
        """
        if self.min_stack:
            return self.min_stack[-1]
        return 0
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()


"""
Testcase 1
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Testcase 2
["MinStack","push","push","push","getMin","pop","getMin"]
[[],[0],[1],[0],[],[],[]]

Testcase 3
["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
[[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
"""