# space complexity - O(n)
# time complexity - O(1)
# using 2 stack approach - one main stack and other is min stack
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minS = float('inf')
    def push(self, x: int) -> None:
        if min(x,self.minS) == x:
            self.stack.append(self.minS)
            self.minS = x
        self.stack.append(x)
        # print(self.stack, self.minS)

    def pop(self) -> None:
        if self.stack and self.stack.pop() == self.minS:
            self.minS = self.stack.pop()

    def top(self) -> int:
        if self.stack:
            return self.stack[-1]
        else: return None

    def getMin(self) -> int:
        if self.stack:
            return self.minS
        else:
            return None
