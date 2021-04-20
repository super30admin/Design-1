class Myminstack(object):
    def __init__(self):
        self.stack = []

    def push(self, x):
        if self.stack:
            self.stack.append((x, min(x, self.getMin())))
        else:
            self.stack.append((x,x))

    def pop(self):
         if self.stack:
            self.stack.pop()

    def top(self):
        return self.stack[-1][0] if self.stack else None

    def getMin(self):
         return self.stack[-1][1] if self.stack else None

# if __name__ == '__main__':
#
#
#
#
#
#
# 
#
#


