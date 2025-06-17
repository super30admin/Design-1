# Time Complexity: O(1)
# Space Complexity: O(n)
#Did this code successfully run on Leetcode : Yes
class MinStack:

    def __init__(self):
        self.stack = []
        self.minstack = []  # Using second stack to maintain mininum values

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.minstack or val <= self.minstack[-1]:
            # adding val to second stack only if it is less than or equal to top value in that stack
            self.minstack.append(val)

    def pop(self) -> None:
        if self.stack:
            popval = self.stack.pop()

        if self.minstack and self.minstack[
            -1] == popval:  # if val popped in first stack is same as top value in second stack then pop it to maintain consistency
            self.minstack.pop()

    def top(self) -> int:
        if self.stack:
            return self.stack[-1]
        return []

    def getMin(self) -> int:
        if self.minstack:
            return self.minstack[-1]  # the top value in second stack will always be minimum value
        return []

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()