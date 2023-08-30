# In init method I defined stack and global min with max size of system
# In push method i checked if value is min than global min if yes append to stack and set as global min.
# In pop method take out the top value of stack and if its min set new min value
class MinStack(object):

    def __init__(self):
        self.stack = []
        self.min = int(sys.maxsize)
        

    def push(self, val):
        if val<= self.min:
            self.stack.append(self.min)
            self.min=val
        self.stack.append(val)
        

    def pop(self):
        popped = self.stack.pop()
        if popped==self.min:
            self.min=self.stack.pop()
        

    def top(self):
        return self.stack[-1]
        

    def getMin(self):
        return self.min
        