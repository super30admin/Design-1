
Learn more or give us feedback
class Stack:  # stack implementation
    def __init__(self):
        self.items = []

    def isEmpty(self):
        return self.items == []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        return self.items.pop()

    def peek(self):
        return self.items[len(self.items) - 1]

    def size(self):
        return len(self.items)
class min_stack:   #using 2 stacks to get O(1) for min elements
    def __init__(self):
        self.org_stk = Stack()
        self.min_value =Stack()
        self.min_value.push(float("inf"))
    def push(self,val):
        if self.min_value.peek() >= val:  #if its not less than min
            self.org_stk.push(val)
            self.min_value.push(val)
        else:                             #if its min
            self.org_stk.push(val)
            self.min_value.push(self.min_value.peek())
    def pop(self):
        #self.min_value.peek() == self.org_stk.peek():
        if self.org_stk == [] and len(self.min_value) == 1:
            return None
        else:
            k=self.min_value.pop()
            j=self.org_stk.pop()
            return j
    def peek(self):
        return self.org_stk.peek()

    def getMin(self):
        return self.min_value.peek()
    def isEmpty(self):
        return self.org_stk.isEmpty()

stk = min_stack()  # calling  special stack named as min_stack
stk.push(5.0)
stk.push(6.0)
stk.push(7.0)
stk.push(4.0)
stk.push(3.0)
print(stk.getMin())
print(stk.pop())
print(stk.getMin())

© 2019 GitHub, Inc.
Terms
Privacy
Security
Status
Help
Contact GitHub
Pricing
API
Training
Blog
About
