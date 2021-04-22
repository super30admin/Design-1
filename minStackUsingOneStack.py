class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.minStack = []
        self.minValue = float('inf')

    def push(self, val: int) -> None:
        
        if val<=self.minValue:
            self.minStack.append(self.minValue)
            self.minValue = val
        
        self.minStack.append(val)

    def pop(self) -> None:
        
        poppedValue = self.minStack.pop()
        
        if poppedValue == self.minValue:
            self.minValue = self.minStack.pop()
        
    def top(self) -> int:
        return self.minStack[-1]
        

    def getMin(self) -> int:
        return self.minValue

#  Time and space complexity remain the same - average time complexity changes but that is not relevant in the worst case.
#  Approach we use while usimg just one stack is one where if you find a new value that is less than min, you push prev min and then also push the new value with that as well. While popping, if the popped elemeent is wqual to the minimum value, pop another element and set that value to the min value. 
    
    
# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
