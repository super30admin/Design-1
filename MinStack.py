"""
Time = O(1)
space = O(n) 
Successfully excecuted on leetcode


"""

class MinStack:

    def __init__(self):
        self.stack = []


    def push(self, x):
        curMin = self.getMin()
        if curMin == None or x < curMin:
            curMin = x # keep track/ update curMin while pushing
        self.stack.append((x, curMin))

    def pop(self):
        self.stack.pop()


    def top(self):
        if len(self.stack == 0:
            return None
        else:
            return self.stack[len(self.stack) - 1][0]


    # @return an integer
    def getMin(self):
        if len(self.stack) == 0: #if stack empty
            return None
        else:
            return self.stack[len(self.stack) - 1][1]