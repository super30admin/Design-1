# Min Stack design using 2 Stacks where we will use one separate stack to store the minimum values
# TC: O(1) for all the methods(push,pop,top, get Min)
# SC: O(n) for number of elements stored in stack
class MinStack:
    def __init__(self):
        self.stack = []  # Main stack to store values

    def push(self, val):
        if not self.stack:
            self.stack.append(
                (val, val)
            )  # If stack is empty, store the value and the min value
        else:
            current_min = self.stack[-1][1]  # get the current minimum value
            self.stack.append(
                (val, min(val, current_min))
            )  # Store value and updated minimum

    def pop(self):
        self.stack.pop()  # pop from the stack

    def top(self):
        return self.stack[-1][0]  # Return top element from the main stack

    def getMin(self):
        return self.stack[-1][1]  # Return the current minimum value from the stack


# Your MinSTack object will be instantiated and called as such:
min_stack = MinStack()
min_stack.push(1)
min_stack.push(4)
min_stack.push(0)

print(min_stack.getMin())  # 0
min_stack.pop()
print(min_stack.getMin())  # 4
print(min_stack.top())  # 4
