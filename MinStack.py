# Time Complexity o(1) for all

class MinStack:

    def __init__(self):
        self.stack = []
        self.isFirstValue = True

    def push(self, val: int) -> None:

        if(self.isFirstValue == True):
            minVal = val
            self.stack.append([val,minVal])
            self.isFirstValue = False
        else:
            if(self.stack[-1][1] < val):
                self.stack.append([val,self.stack[-1][1]])
            else:
                self.stack.append([val,val])

    def pop(self) -> None:
        self.stack.pop()
        if(len(self.stack)==0):
            self.isFirstValue = True

    def top(self) -> int:

        return self.stack[-1][0]

    def getMin(self) -> int:
        return self.stack[-1][1]



obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(3)
obj.push(-5)
obj.push(4)

print(obj.top())
print(obj.getMin())


