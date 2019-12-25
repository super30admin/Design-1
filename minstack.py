class MinStack:

    def __init__(self): #Intializing main stack and min stack to store incoming and minimum elements.
        self.mainst = []
        self.minst = []
        self.min = float("inf") #Intializing infinity to Minimum
        
    def push(self, x):
        if x < self.min: #Checks if the incoming element is less than min.If it is less than min that update min
            self.min = x
             
        self.mainst.append(x) #Append incoming element to main stack
        self.minst.append(self.min) ##Append min element to min stack
        
    def pop(self):##Checks if the main and min stacks are empty if not pop the element from both the stacks and update min
        
        if len(self.mainst) == 0:
            return None
        
        else:
            self.mainst.pop()
            self.minst.pop()
            
        if len(self.minst) == 0:
            return None
        else:
            self.min = self.minst[-1]
            
    def top(self):##retur the top element of main stack
        if len(self.mainst) == 0:
            return None
        return self.mainst[-1]
        
    def getMin(self):#returns the top element in min stack
        if len(self.minst) == 0:
            return None 
        
        else:
            return self.minst[-1]
    
    def isEmpty(self):
         return self.mainst == []
        


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(3)

obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()


