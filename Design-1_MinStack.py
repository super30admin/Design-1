# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MinStack:

    def __init__(self):
        self.stack = []
        self.min = float("inf")

    def push(self, value: int) -> None:
        if value <= self.min:
            self.stack.append(self.min)
            self.min = value
        self.stack.append(value)

    def pop(self) -> None:
        if self.stack:
            popped_value = self.stack.pop()
            if popped_value == self.min:
                self.min = self.stack.pop()
        
    def top(self) -> int:
        if self.stack:
            return self.stack[-1]
        return None

    def getMin(self) -> int:
        return self.min

#Unit test
# commands = ["MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"]
# arguments = [[], [-2], [0], [-3], [], [], [], []]

# output = []
# obj = None

# for cmd, args in zip(commands, arguments):
#     if cmd == "MinStack":
#         obj = MinStack()
#         output.append(None)
#     elif cmd == "push":
#         output.append(obj.push(args[0]))
#     elif cmd == "pop":
#         output.append(obj.pop())
#     elif cmd == "top":
#         output.append(obj.top())
#     elif cmd == "getMin":
#         output.append(obj.getMin())

# print("Output:", output)