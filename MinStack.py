"""
Time Complexity: O(1)
Space Complexity: O(n)
Did this code run successfully on leetcode: No, this problem was slightly different than the one on leetcode.

Problem: 
Design a SplStack that supports all the stack operations push, pop, isEmpty, isFull and an operation getMin() 
which should return minimum element from the SplStack. All these operations must be O(1). To implement this, 
you should only use standard Stack data structure.
"""

class MinStack:
    def __init__(self, maxSize):
    """Initializing the Constructor"""
        self.stack = []                 # list implemetation of stack
        self.maxSize = maxSize          # maximum size of the stack
        self.CurSize = 0                # current size of the stack
        self.minElem = None             # minimum elementon the stack
    
    def push(self, e):
    """Push element e on the stack, if the stack is not full"""
        if not self.isFull():           # append the new element only if the stack is not full
            self.stack.append(e)
            self.CurSize += 1           # increment current size of the stack
            self.getMin()               # calculate minimum element at every call to push so whenver getMin()
                                        # is called, it will alway return the minimum element
        else:
            print("Stack is full")
    
    def pop(self):
    """Pop the element at the top, if the stack is not empty"""
        if not self.isEmpty():          # pop element only if stack is not empty
            self.CurSize -= 1           # decrement current size by 1
            return self.stack.pop()
        else:
            return "Stack is already empty"
            
    def top(self):
    """Return the element at the top of the stack"""
        if not self.isEmpty():          # return the element at the top of the stack if the stack is not empty
            return self.stack[-1]
        else:
            print("Stack is empty")
        
    def isEmpty(self):
    """Checks if the stack is empty"""
        return self.CurSize == 0        
    
    def isFull(self):
    """Checks if the stack is full"""
        return self.CurSize == self.maxSize
        
    def getMin(self):
    """Gets the minimum element in the stack"""
        if self.isEmpty():
            return None
        else:
            if self.minElem == None:
                self.minElem = self.top()
            elif self.minElem > self.top():
                self.minElem = self.top()
        return self.minElem

# Testing 
s = MinStack(5)
print(s.getMin())
s.push(6)
s.push(8)
s.push(-10)
s.push(1)
s.push(12)

print(s.isFull())
s.push(5)
print(s.pop())
print(s.isFull())
s.push(16)
print(s.getMin())
print(s.pop())
print(s.pop())
print(s.pop())
print(s.pop())
print(s.pop())
print("Popping: " + str(s.pop()))
print("Is Stack Empty? " + str(s.isEmpty()))