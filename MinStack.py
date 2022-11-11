# Time Complexity : O(1) to push, pop, getting top element and getting minimum
# Space Complexity : O(N) since we need to create a stack and in worse case we have to add min
                    # elem in stack on each push
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

import sys
class MinStack:

    # Initialize stack and a variable to keep track of the minimum element
    def __init__(self):
        self.stack = []
        self.min_elem = sys.maxsize

    # if the val is less than or equal to the current min, we first add the min element to stack
    # so that when popping we can update the minimum for reamining stack.
    # Then we push the actual value to the stack and update the min
    # if the value is not the new min, we just add it to the stack
    def push(self, val: int) -> None:
        if (val <= self.min_elem):
            self.stack.append(self.min_elem)
            self.stack.append(val)
            self.min_elem = val
        else:
            self.stack.append(val)

    # if the top element is the current min, we update the new min to new_temporary top
    # and pop it as it was just the min elem for the reminaing stack and not the top value
    def pop(self) -> None:
        prev_top = self.stack.pop()
        if (prev_top == self.min_elem):
            self.min_elem = self.stack.pop()
        return

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_elem

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()