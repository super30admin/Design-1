class MinStack:
    # Maintain 2 stacks i.e lists a normal one and the other to keep track of the minimum
    # Push: push normally in my_stack and for min_stack check the min val and push
    # Pop: pop from both stacks
    # Top: return the top of the my_stack i.e the last value
    # Getmin: return the last value of min_stack

    # Time: O(1) for every operation
    # Space: O(n) + O(n) for 2 different stacks which is O(n)

    def __init__(self):
        self.my_stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        self.my_stack.append(val)
        min_val = 0
        if not self.min_stack:
            min_val = val
        else:
            min_val = min(self.min_stack[-1], val)
        self.min_stack.append(min_val)

    def pop(self) -> None:
        self.my_stack.pop()
        self.min_stack.pop()

    def top(self) -> int:
        return self.my_stack[len(self.my_stack) - 1]

    def getMin(self) -> int:
        return self.min_stack[len(self.min_stack) - 1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()