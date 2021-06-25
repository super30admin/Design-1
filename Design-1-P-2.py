class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minStack = []

    def push(self, val) :
        self.stack.append(val)
        self.minStack.append(val)

    def pop(self) :
        if (self.stack):
            self.stack.pop()
        self.minStack.pop()

    def top(self) :
        return self.stack[-1]

    def getMin(self) :
        print min(self.stack)

# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(10)
obj.push(20)
obj.push(30)
obj.push(40)
obj.pop()

obj.top()
obj.getMin()
