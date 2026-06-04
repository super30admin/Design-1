class MinStack:
    
    # we maintain 2 arrays, one for the stack, and one for all our minimums with each push
    def __init__(self):
        self.stack = []
        self.minStack = []

    # when pushing on top of stack, also push the min of minStack and new val to minStack
    # this allows O(1) retain our minimum with every push
    # Stack will grow as follows:
    # Stack [ 5, 6, 8, 4, 7, 3 ]
    # MinStack [ 5, 5, 5, 4, 4, 3]
    # Complexity: O(1)
    def push(self, val: int) -> None:
        self.stack.append(val)
        minimum = min(val, self.minStack[-1] if self.minStack else val)
        self.minStack.append(minimum)

    # pop from both stacks so that we always have previous min in the minStack
    # Complexity: O(1)
    def pop(self) -> None:
        self.minStack.pop()
        self.stack.pop()

    # return top of Stack
    # Complexity: O(1)
    def top(self) -> int:
        if len(self.stack) > 0:
            return self.stack[-1]

    # Complexity: O(1)
    def getMin(self) -> int:
        return self.minStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()