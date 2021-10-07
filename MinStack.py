class MinStack:

    def __init__(self):
        self.items = []
        self.minstack = []

    def push(self, val: int) -> None:
        self.items.append(val)
        if len(self.minstack) == 0 or self.minstack[-1] >= val:
            self.minstack.append(val) 


    def pop(self) -> None:
        if len(self.items) == 0:
            return
        else:
            popped = self.items.pop()
            if popped == self.minstack[-1]:
                self.minstack.pop()
            return popped
        
    def top(self) -> int:
        return self.items[-1]

    def getMin(self) -> int:
        return self.minstack[-1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()