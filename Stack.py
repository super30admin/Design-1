class MinStack(object):

    def __init__(self):
        
        self.stack = []

    def push(self, x):
        
        prev_min = self.getMin()
        if prev_min == None or x < prev_min:
            self.stack.append((x, x))
        else:
            self.stack.append((x, prev_min))
        

    def pop(self):
        
        self.stack.pop()

    def top(self):
        
        return self.stack[-1][0]

    def getMin(self):
        
        if len(self.stack) == 0:
            return None
        return self.stack[-1][1]



obj = MinStack()
obj.push(4)
obj.push(5)
obj.pop()
param_1 = obj.top()
param_2 = obj.getMin()