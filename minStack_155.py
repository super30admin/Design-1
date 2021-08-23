#################Mins stack problem###########
'''
Insertion - O(1)
pop - O(1)
top - O(1)
getMin - O(1)

space complexity - O(n)
'''
##############################################

class MinStack:
    
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack1=[]
        self.minValue = float('inf')

    def push(self, val: int) -> None:
        if(len(self.stack1) == 0):
            self.stack1.append(self.minValue)

        if(val < self.minValue):
            self.minValue = val

        self.stack1.append(val)
        self.stack1.append(self.minValue)
        
        
    def pop(self) -> None:
        if(self.stack1[-1] == self.minValue): #Pop the elements and change the min val
            #print(self.stack1)
            self.stack1.pop(-1)
            self.stack1.pop(-1)
            self.minValue = self.stack1[-1]
        else: #min val remains the same. Just pop the element
            self.stack1.pop(-1)
            self.stack1.pop(-1)

    def top(self) -> int:
        return self.stack1[-2]
        

    def getMin(self) -> int:
        return self.stack1[-1]
        

# Your MinStack object will be instantiated and called as such:
obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
obj.push(2147483646)
obj.push(2147483646)
obj.push(2147483647)
print(obj.top())
obj.pop()
print(obj.getMin())
obj.pop()
print(obj.getMin())
print(obj.stack1)
obj.pop()
print(obj.stack1)
obj.push(-2147483648)
print(obj.stack1)

# ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
# [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]