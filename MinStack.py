#Time Complexity : O(1)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class MinStack:
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.minstack = []
        self.stack = []

    def push(self, x: int) -> None:
        self.stack.append(x)
        if self.minstack:
            if self.minstack[-1] >= x:
                self.minstack.append(x)
        else:
            self.minstack.append(x)

    def pop(self) -> None:
        if self.stack:
            top = self.stack.pop()
            if self.minstack and self.minstack[-1] == top:
                self.minstack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        if self.minstack:
            return self.minstack[-1]
        return 0
