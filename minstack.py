class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []

    def push(self, val):
        self.stack.append(val)
        if not self.minStack or val <= self.minStack[-1]:
            self.minStack.append(val)

    def pop(self):
        if self.stack.pop() == self.minStack[-1]:
            self.minStack.pop()

    def top(self):
        return self.stack[-1]

    def getMin(self):
        return self.minStack[-1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(value)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

# Time and Space complexities for minstack
# Operation	Time	Space
# push	    O(1)	O(n)
# pop	    O(1)	O(1)
# top	    O(1)	O(1)
# getMin	O(1)	O(1)