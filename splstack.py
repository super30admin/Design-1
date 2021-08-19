
#This is a wrong solution - I wanted to try priority queue with the solution

class MinStack:

    MAX = 10

    def __init__(self):

        self.min = None
        self.stack = [None for i in range(MinStack.MAX)]
        self.minstack = [None]
        self.count = 0

    def push(self, val):
        
        if(self.min == None):
            
            self.min = val
            self.stack[self.count] = val
            self.minstack.append(val)
            
        elif(self.min > val):
            
            self.min = val
            self.stack[self.count] = val
            self.minstack.append(val)
            
        else:
            
            self.stack[self.count] = val

        self.count = self.count + 1

        print('Min',self.minstack)
        print('Stack',self.stack)
        

    def pop(self):

        self.stack.pop()
        print(self.minstack[-1])
        if(self.min == self.minstack[-1] and self.min != None):

            self.minstack.pop()
            self.min = self.minstack[-1]

        

    def top(self):

        if(len(self.stack)>0):

            return self.stack[-1]
        

    def getMin(self):
        
        return self.min


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(1)
obj.push(-2)
obj.pop()
param_3 = obj.top()
obj.push(-3)
param_4 = obj.getMin()
print(param_4)
