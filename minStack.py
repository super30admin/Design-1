class MinStack:
    def __init__(self):
        self.stack = []
        self.min = []
    
    @staticmethod
    def isNull(stack):
        return len(stack) == 0
    
    def push(self, val):
        if len(self.stack) == 0 and len(self.min) == 0:
            self.stack.append(val)
            self.min.append(val)
        elif val < self.min[-1]:
            self.stack.append(val)
            self.min.append(val)
        else:
            self.stack.append(val)
    
    def pop(self):
        if self.isNull(self.stack):
            return "empty stack"
        
        if self.stack[-1] == self.min[-1]:
            self.stack.pop()
            self.min.pop()
        else:
            self.stack.pop()
    
    def top(self):
        if self.isNull(self.stack):
            return "empty stack"
        return self.stack[-1]
    
    def getMin(self):
        if self.isNull(self.stack):
            return "empty stack"
        return self.min[-1]


stack = MinStack()

print(stack.pop())
print(stack.top())
print(stack.getMin())

stack.push(1)
stack.push(2)
stack.push(-1)
stack.push(3)
stack.push(4)
stack.push(-2)
stack.push(5)
stack.push(-1)
stack.push(6)

print(stack.top())
print(stack.getMin())

stack.pop()
stack.pop()
stack.pop()
stack.pop()

print(stack.getMin())