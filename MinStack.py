# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes

class MinStack(object):

    def __init__(self):
        self.stack = []
        self.minval = float('inf')
        self.popval = 0

    def push(self, val):
        if self.minval >= val:
            self.stack.append(self.minval)
            self.stack.append(val)
            self.minval = val
        else:
            self.stack.append(val)

    def pop(self):
        if len(self.stack) == 0 :
            return None
        elif self.minval != self.stack[-1]:
            self.popval = self.stack.pop()
        else:
            self.popval = self.stack.pop()
            self.minval = self.stack.pop()
        return self.popval
        

    def top(self):
        return self.stack[-1]
        

    def getMin(self):
        return self.minval

     
obj = MinStack()
obj.push(0)
obj.push(1)
obj.push(0)
param_1 = obj.getMin()
print("Min Value: ", param_1)
obj.pop()
param_2 = obj.top()
print("Top of the stack value: ", param_2)
param_3 = obj.getMin()
print("Min Value: ", param_3)