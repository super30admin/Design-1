
#Approach 1:
#Maintains two stacks: one for actual values and one for tracking minimum values.
#every push also pushes the current minimum to minSt, ensuring O(1) access to min.
#The min is updated after each pop
#Time O(1): every method does a constant number of append, pop or [-1] operations.
#Space O(n): stack holds n values and minstack holds n minimums, plus the starting inf. That’s about 2n, which is still O(n).

class MinStack:

    def __init__(self):
        self.stack = []
        self.minstack = []
        self.min = float('inf')
        self.minstack.append(self.min)

    def push(self, value: int) -> None:
        self.min = min(self.min, value)
        self.stack.append(value)
        self.minstack.append(self.min)

    def pop(self) -> None:
        self.stack.pop()
        self.minstack.pop()
        self.min = self.minstack[-1]

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(value)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

#Approach 2: using the single stack plus a variable min that holds the current min 
class MinStack:

    def __init__(self):
        self.stack = []
        self.min = float('inf')

    def push(self, value: int) -> None:
        if value <= self.min:
            self.stack.append(self.min)
            self.min = value
        self.stack.append(value)

    def pop(self) -> None:
        popped= self.stack.pop()
        if self.min == popped:
            self.min = self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(value)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()