class stack:
    def __init__(self):
        self.stack=[]
        self.count=0
        self.max_count=6
        self.minimum=0
    def push(self,value):
        if self.stack==[]:
            self.stack.append(value)
            self.minimum=value
        elif value<self.minimum:
            self.stack.append(value) 
            self.minimum = value
        else:
            self.stack.append(value)
        print("element",value,"is pushed")
    def getMin(self): 
        if self.stack==[]: 
            return "Stack is empty"
        else: 
            print("The minimum element is:",self.minimum)
    def pop(self):
        if self.stack==[]:
            return "Stack is empty"
        else:
            ele=self.stack.pop()
        print("element",ele,"is popped")
    def isEmpty(self):
        if len(self.stack)==0:
            return True
        else:
            return False
    def isFull(self):
        if len(self.stack)==self.max_count:
            return True
        else:
            return False