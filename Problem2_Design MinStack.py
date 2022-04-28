
"Time complexity - O(1)"
class MinStack(object):

    def __init__(self):
        self.stac = []

    def push(self, val):
        self.stac.append(val)

    def pop(self):
        self.stac.pop()

    def top(self):
        return self.stac[-1] if self.stac else 0

    def getMin(self):
        return min(self.stac)


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(-3)
obj.getMin()
obj.pop()
obj.top()
