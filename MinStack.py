import collections
class MinStack(object):    
    def __init__(self):
        self.min_ = deque()
        self.nums = deque()

    def push(self, val):
        self.nums.append(val)
        if not self.min_ or val <= self.min_[-1]:
            self.min_.append(val)
        
    def pop(self):
        val = self.nums.pop()
        if val == self.min_[-1]:
            self.min_.pop()

    def top(self):
        return self.nums[-1]

    def getMin(self):
        return self.min_[-1]
