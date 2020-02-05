'''
Time Complexity : O(1)

Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes

Any problem you faced while coding this : None

Explaination: Create 2 stacks, one for maintaining the values
and one for the maintaining the minimum values.
When we push, we push the element in the first stack and push
the min(incoming value, top of stack of minimum value) into the
minimum stack. When we pop, we pop from both the stacks.
'''

import math

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minStack = [math.inf]

    def push(self, x: int) -> None:

        self.stack.append(x)
        minElem = min(x, self.getMin())
        self.minStack.append(minElem)

    def pop(self) -> None:

        self.stack.pop()
        self.minStack.pop()

    def peek(self) -> int:

        return self.stack[-1]

    def getMin(self) -> int:

        return self.minStack[-1]

    def isEmpty(self) -> int:

        if len(self.stack) == 0:
            return True
        else:
            return False

#Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(2)
obj.push(3)
obj.push(1)
obj.pop()
print("Minimum is: " + str(obj.getMin()))

