class MinStack:

    def __init__(self):
        self.stack=[]
        self.min_stack=[]

    def push(self,val):
        self.stack.append(val)
        if not self.min_stack or val<=self.min_stack[-1]:
            self.min_stack.append(val)
    
    def pop(self):
        val= self.stack.pop()
        if val==self.min_stack[-1]:
            self.min_stack.pop()

    def top(self):
        return self.stack[-1]
    
    def getMin(self):
        return self.min_stack[-1]

commands=["MinStack","push","push","push","getMin","pop","top","getMin"]
values=[[],[-2],[0],[-3],[],[],[],[]]

output=[]
min_stack=None

for command,val in zip(commands,values):
    if command=="MinStack":
        min_stack=MinStack()
        output.append(None)
    elif command=="push":
        min_stack.push(val[0])
        output.append(None)
    elif command=="pop":
        min_stack.pop()
        output.append(None)
    elif command =="top":
        output.append(min_stack.top())
    elif command =="getMin":
        output.append(min_stack.getMin())

print(output)