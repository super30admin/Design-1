
#This is a wrong solution - I wanted to try priority queue with the solution

class MinStack(object):

    def __init__(self):

        self.min = None
        self.stack = []
        

    def push(self, val):
        
        if(self.min == None):
            
            self.min = val
            self.stack.append(val)
            
        elif(self.min > val):
            
            self.min = val
            self.stack.append(val)
            
        else:
            
            self.stack.append(val)

        print(self.min)
        

    def pop(self):

        self.stack.pop()
        

    def top(self):

        if(len(self.stack)>0):

            return self.stack[-1]
        

    def getMin(self):
        
        return self.min


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push()
obj.push(-2)
obj.pop()
param_3 = obj.top()
obj.push(-3)
param_4 = obj.getMin()
print(param_4)
