'''
Brute Force Approach : 

Using 2 stacks : Original Stack and Minimum stack.

1. 1 stack to save the original contents that are pushed
2. 2nd stack to save the contents by comparing the element that is to be pushed and the minimum element available in the min stack.

Push operations will take 0(2N) space complexity. Classic example would be when the elements that are to be pushed to the stack are in descending order.
In this case, both the stacks will get populated at every operation.

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        self.s1.append(x)
        if not self.s2 or x<=self.s2[-1]:
            self.s2.append(x)

    def pop(self) -> None:
        if self.s1[-1] == self.s2[-1]:
            self.s2.pop()
        self.s1.pop()

    def top(self) -> int:
        return self.s1[-1]

    def getMin(self) -> int:
        return self.s2[-1]

Optimal Approach : Using a single stack, tracking the last min and current min elements everytime the element is pushed. The min elements are always at the top of the stack.
Below is the Optimal Approach
'''

class MinStack:

    def __init__(self):
        self.stack = []
        self.minimum = float('inf')

    def push(self, val: int) -> None:
        
        if val <= self.minimum:
            self.stack.append(self.minimum)
            self.minimum = val

        self.stack.append(val)

    def pop(self) -> None:
        
        val = self.stack.pop(-1)
        if self.minimum == val:
            self.minimum = self.stack.pop(-1)

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minimum



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
