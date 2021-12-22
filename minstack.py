"""
# Time Complexity : push, pop, top: O(1), getmin: O(N)
# Space Complexity : don't know how to calculate
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
"""
class MinStack(object):

    def __init__(self):
        self.stack = []
        

    def push(self, val):
        self.stack.append(val)
        

    def pop(self):
        if self.stack == []: return print("stack is empty")
        self.stack.pop()
        

    def top(self):
        if self.stack == []: return print("stack is empty")
        return self.stack[len(self.stack) - 1] #because [] starts from 0 and len starts from 1

    def getMin(self):
        if self.stack == []: return print("stack is empty")
        previousMinEle = self.stack[0]
        for currentEle in self.stack:
           if currentEle < previousMinEle:
               previousMinEle = currentEle
        return previousMinEle
        



obj = MinStack()
obj.push(134)
obj.push(52)
obj.push(75)
obj.push(82)
obj.push(33)
print(obj.stack)
obj.pop()
print(obj.stack)
param_3 = obj.top()
print(param_3)
param_4 = obj.getMin()
print(param_4)