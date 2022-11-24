import sys


class MinStack:

    def __init__(self):
        self.minst = []
        self.topr = -1

    def push(self, val: int) -> None:
        if self.topr == -1:
            self.topr += 1
            self.minst.append([val, val])
            return
        self.minst.append([val, min(self.minst[self.topr][1], val)])
        self.topr += 1

    def pop(self) -> None:
        if self.topr == -1:
            print("Stack is Empty")
            return
        self.minst.pop()
        self.topr -= 1

    def top(self) -> int:
        if self.topr == -1:
            print("Stack is Empty")
            return
        return self.minst[self.topr][0]

    def getMin(self) -> int:
        # print(self.minst)
        if self.topr == -1:
            print("Stack is Empty")
            return
        return self.minst[self.topr][1]


obj = MinStack()
for i in range(5,10):
    obj.push(i)
obj.pop()
print(obj.top())
print(obj.getMin())