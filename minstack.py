"""
Time complexity: O(1)
space complexity: O(n)

Explaination:
 1.we will be using a single stack along with a minimum variable
 2.everytime u push a variable inside the stack, if the variable is smaller than the already exisiting minimum, you push the the already existing minimum and then push the new variable
 3.when popping, if the minimum and the popped item are same, it means you are removing the minimum.hence pop it once again to get the previous minimum

Execution:Complete

"""


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = sys.maxsize
        self.stack.append(self.min)

    def push(self, x: int) -> None:
        if x <= self.min:
            self.stack.append(self.min)
            self.min = x
        self.stack.append(x)

    def pop(self) -> None:
        item = self.stack.pop()
        if item == self.min:
            self.min = self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()