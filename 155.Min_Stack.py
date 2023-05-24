class MinStack:

    def __init__(self):
        self.counter_top = 0
        self.pop_counter = 0
        self.stack = []
        self.MinStack = []
        self.min_ele = None
        self.min = None

    def push(self, val: int) -> None:
        self.stack.append(val)
        self.counter_top += 1
        # if self.counter_top == 1:
        #     self.min_ele = self.stack[0]
        #     self.MinStack.append(self.min_ele)
        # if self.min_ele < self.stack[self.counter_top-1]:
        #     self.min = self.min_ele
        #     self.MinStack
        # else:
        #     self.min = self.stack[self.counter_top-1]
        val = min(val,self.MinStack[-1] if self.MinStack else val)
        self.MinStack.append(val)
        self.pop_counter+=1
        
    def pop(self) -> None:
        del self.stack[-1]
        del self.MinStack[-1]
        if self.counter_top !=1:
            self.counter_top=-1
        else:
            self.counter_top
        
        

    def top(self) -> int:
        return self.stack[self.counter_top]

    def getMin(self) -> int:
        return self.MinStack[-1]
        


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(1)
obj.push(2)
obj.push(-3)
obj.push(-4)
obj.push(-4)
obj.push(-5)
obj.push(8)
obj.pop()
print(obj.stack)
print(obj.top())
print(obj.getMin())