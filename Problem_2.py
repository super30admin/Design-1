class MinStack(object):

    def __init__(self):
        self.stack = []
        

    def push(self, val):
        self.stack.append(val)
        

    def pop(self):
        if (len(self.stack)):
            self.stack.pop()
        return
        

    def top(self):
        if (len(self.stack)):
            return self.stack[len(self.stack) -1 ]
        
    def getMin(self):
        if (len(self.stack)):
           min = self.stack[len(self.stack) -1]
           for i in range(0, len(self.stack) -1):
                if min > self.stack[i]:
                    min = self.stack[i]
        return min
        
# Input
# ["MinStack","push","push","push","getMin","pop","top","getMin"]
# [[],[-2],[0],[-3],[],[],[],[]]

# Output
# [null,null,null,null,-3,null,0,-2]


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(-3)
print(obj.getMin())
obj.pop()
print(obj.top())
print(obj.getMin())