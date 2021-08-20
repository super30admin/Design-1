
#This is a wrong solution - I wanted to try priority queue with the solution

class MinStack:

    def __init__(self):

        self.min = None
        self.stack = []
        self.minstack = [None]
        self.count = 0

    def push(self, val):
        
        if(self.min == None):
            
            self.min = val
            self.stack.append(val)
            self.minstack.append(val)
            
        elif(self.min >= val):
            
            self.min = val
            self.stack.append(val)
            self.minstack.append(val)
            
        else:
            
            self.stack.append(val)

        print('Min',self.minstack)
        print('Stack',self.stack)
        

    def pop(self):

        if(self.min == self.stack[-1] and self.min != None):

            self.minstack.pop()
            self.min = self.minstack[-1]
            self.stack.pop()
            print('Elements in stack',self.minstack)
        else:
            print('Elements in stack',self.stack)
            self.stack.pop()

    def top(self):

        if(len(self.stack)>0):

            return self.stack[-1]
        
    def getMin(self):
        
        return self.min


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(0)
obj.push(1)
obj.push(0)
param_3 = obj.top()
print(param_3)
obj.pop()
param_4 = obj.getMin()
print(param_4)
