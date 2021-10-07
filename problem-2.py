# Time complexity is O(1) and space complexity is O(n)
# Was able to run on leetcode
class MinStack:
    # Initializing stack and initializing minimum stack to hold the minimum elements
    def __init__(self):
        self.stack = []
        self.minstack = []
        self.size = 0

    def push(self, val: int) -> None:
        # If there is no element in the stack then pushing the value in stack as well as minimum stack else checking whether tthe value is less than minimum stack value then pushing the value in minimum stack as well as stack
        if self.size == 0:
            self.minstack.append(val)
        elif val <= self.minstack[-1]:
            self.minstack.append(val)

        self.stack.append(val)
        self.size += 1

    def pop(self) -> None:
        # storing the top value of stack in temp and popping it
        temp = self.stack.pop()
        self.size -= 1
# comparing the top element of stack with the minimum stack and popping it if same element is present
        if temp == self.minstack[-1]:
            self.minstack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minstack[-1]
