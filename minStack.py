'''
Time Complexity : O(1)

Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes

Any problem you faced while coding this : None

Explaination:
Solution1 - Create 2 stacks, one for maintaining the values
and one for the maintaining the minimum values.
When we push, we push the element in the first stack and push
the min(incoming value, top of stack of minimum value) into the
minimum stack. When we pop, we pop from both the stacks.

Solution2 - Create 1 stack and a minimum variable to keep the
current minimum. While pushing, If the minimum value < incoming value
then push the minimum value into the stack and then push the new value
else push the new value.
While popping, pop the element and check if the popped element is the
minimum value, if it is then pop again as the minimum value would be
added on top the actual value to be popped if it was not the minimum value.
'''

import math

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = math.inf

    def push(self, x: int) -> None:

        if x <= self.min:
            self.stack.append(self.min)
            self.min = x
        self.stack.append(x)

    def pop(self) -> None:

        temp = self.stack.pop()
        if temp == self.min:
            self.min = self.stack.pop()

    def peek(self) -> int:

        return self.stack[-1]

    def getMin(self) -> int:

        return self.min

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

