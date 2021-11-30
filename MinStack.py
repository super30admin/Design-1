#Time Ccomplexity : O(1)
#Space Complexity : O(n)

class MinStack(object):

    def __init__(self):
        self.stack = []
        

    def push(self, val):
        self.stack.append(val)
        

    def pop(self):
        if(len(self.stack)==0):
            print("nothing to pop")
        else:
            removing_element = self.stack[len(self.stack)-1]
            self.stack.remove(removing_element)
        
    def top(self):
        if(len(self.stack)==0):
            print("stack empty")
        else:
            top_element = self.stack[len(self.stack)-1]
            return top_element
        

    def getMin(self):
        if(len(self.stack)==0):
            print("stack is empty")
        else:
            min = self.stack[0]
            for i in self.stack:
                if(i<min):
                    min = i
               
                             
        return min
                
            
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
