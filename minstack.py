class MinStack:
    def __init__(self):
        self.stack = []
        self.list_min = []

    def push(self, x):
        self.stack.append(x)

        if len(self.list_min):
            self.list_min.append(min(self.list_min[-1], x))
        else:
            self.list_min.append(x)

    def pop(self):

        self.stack.pop()
        self.list_min.pop()

    def top(self):
        return self.stack[-1]

    def getMin(self):
        return self.list_min[-1]