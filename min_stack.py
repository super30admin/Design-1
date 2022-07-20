# Time complexity : O(1)
# Space complexity : O(n)
# Leetcode : Solved and submitted

class MinStack:
     
    # Initializing the default two stacks, one for all the elements and other one is to keep the minimum elements
    def __init__(self):
        self.stack = []
        self.min_stack = []

    # To add elements onto the stack, we firstly add it to the general stack, and then check with the top element of the min_stack
    # If any element is lesser than that, we add it to the min stack
    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)

    # We pop the element from the general stack, and from the min_stack, if the same top element is removed from the both the stack
    def pop(self) -> None:
        if self.min_stack[-1] == self.stack[-1]:
            self.min_stack.pop()
        self.stack.pop()

    # This will return the top element of the general stack
    def top(self) -> int:
        return self.stack[-1]

    # This will return the top element of the min_stack
    def getMin(self) -> int:
        return self.min_stack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
