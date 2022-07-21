'''
Time Complexity - 
push() - O(1) 
pop() - O(1)
top() - O(1)
getMin() - O(n)

Space Complexity - O(n)

'''


class MinStack:

    def __init__(self):
        self.stack = []
        self.minimum = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if self.minimum == []:
            self.minimum.append(val)
        elif val <= self.minimum[-1]:
            self.minimum.append(val)
        else:
            self.minimum.append(self.minimum[-1])

    def pop(self) -> None:
        if not self.stack == 0:
            del(self.stack[-1])
            del(self.minimum[-1])

    def top(self) -> int:
        if self.stack == 0:
            return None
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minimum[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
