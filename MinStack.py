class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []

    def push(self, x):
        if not self.stack:
            self.stack.append((x, x))
            return
        current_minimum = self.stack[-1][1]
        self.stack.append((x, min(current_minimum, x)))
        print(self.stack)

    def pop(self):
        return self.stack.pop()

    def top(self):
        return self.stack[-1][0]

    def getMin(self):
        return self.stack[-1][1]

#driver code

min_stack = MinStack()
min_stack.push(1)
min_stack.push(2)
print(min_stack.top())
min_stack.pop()
print(min_stack.stack)
min_stack.push(2)
min_stack.push(3)
min_stack.push(0)
print(min_stack.getMin())




