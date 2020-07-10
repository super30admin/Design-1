# Time Complexity : O(1) - top, push, pop, getMin.
# Space Complexity : O(n) - n : length of the stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : At first I maintained min as a global variable but couldn't handle if the element popped off. Also
# stored 2 values - (value, min) in a node which was as same as using two stack.
#
# Your code here along with comments explaining your approach

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.curr_min = float('inf')

    # if the value to be pushed is less than the current minimum then, push the current minimum so as to keep track if x gets popped in future
    # and update the current minimum and then push the element.
    def push(self, x: int) -> None:
        if x <= self.curr_min:
            self.stack.append(self.curr_min)
            self.curr_min = x
        self.stack.append(x)

    # If the element popped is same as the current minimum, then current minimum is updated which is the value before it (its the order in
    # which we pushed) and is also popped off.
    def pop(self) -> None:
        if len(self.stack) < 1:
            print("ERROR: Stack Underflow")
            return
        popped_elem = self.stack.pop(-1)
        if popped_elem == self.curr_min:
            self.curr_min = self.stack.pop(-1)

    def top(self) -> int:
        if len(self.stack) < 1:
            print("ERROR: Stack Underflow")
            return
        return self.stack[-1]

    def getMin(self) -> int:
        return self.curr_min

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
