# all the methods take O(1) time and O(1) space. We used O(n) space for stack and mins array
class MinStack:
    def __init__(self):
        self.minstack = []
        self.mins = []
    def push(self, x):
        current_min = min(self.mins[-1],x) if len(self.mins) else x
        self.minstack.append(x)
        self.mins.append(current_min)
    def pop(self):
        if len(self.minstack):
            self.minstack.pop()
            self.mins.pop()
    def top(self):
        if len(self.minstack):
            return self.minstack[-1]
    def getMin(self):
        if len(self.minstack):
            return self.mins[-1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()