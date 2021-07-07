#using two stacks
# Will submit one stack solution tomorrow
class MinStack:
    def __init__(self):
        self.min = []
        self.stack = []

    def push(self, x):
        self.stack.append(x)
        if not self.min:
            self.min.append(x)
        else:
            self.min.append(min(x,self.min[-1]))
        print("Pushed element ",x," into stack. Stack:  ",self.stack)

    def pop(self):
        self.stack.pop()
        self.min.pop()
        print("Popped stack.                    Stack:  ",self.stack)

    def top(self):
        print("Last element in stack:                    ",self.stack[-1])
        return self.stack[-1]

    def getMin(self):
        print("Minimium value in stack                   ",self.min[-1])
        return self.min[-1]

stack = MinStack()
stack.push(9)
stack.getMin()
stack.push(8)
stack.push(7)
stack.getMin()
stack.push(10)
stack.top()
stack.push(0)
stack.pop()
stack.getMin()

'''
#output

Pushed element  9  into stack. Stack:   [9]
Minimium value in stack                    9
Pushed element  8  into stack. Stack:   [9, 8]
Pushed element  7  into stack. Stack:   [9, 8, 7]
Minimium value in stack                    7
Pushed element  10  into stack. Stack:   [9, 8, 7, 10]
Last element in stack:                     10
Pushed element  0  into stack. Stack:   [9, 8, 7, 10, 0]
Popped stack.                    Stack:   [9, 8, 7, 10]
Minimium value in stack
'''
