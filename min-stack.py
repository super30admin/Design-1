class MinStack:
    
    # in this solution we are gonna maintain a minstack which will always point to the minimum value available in the stack so far. 
    def __init__(self):
        self.stack1=[]
        self.minstack=[]

    def push(self, val: int) -> None:
        self.stack1.append(val)
        #calculating the minimum value in the stack1 and then appending that onto minstack
        val=min(val,self.minstack[-1] if self.minstack else val)
        self.minstack.append(val)

    def pop(self) -> None:
        self.stack1.pop()
        self.minstack.pop()

    def top(self) -> int:
        return self.stack1[-1]

    def getMin(self) -> int:
        return self.minstack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()