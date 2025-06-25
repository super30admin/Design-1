'''
155. Min Stack
'''

class MinStack: # humne MinStack class banayi hai jo ek stack ko implement karegi (we design a MinStack class that will implement a stack)

    def __init__(self): # constructor hai jo MinStack class ko initialize karega (this is the constructor that will initialize the MinStack class)
        '''Initialize your data structure here.'''
        self.stack = [] # humne ek empty stack banaya hai list data structure ko use karke (we have created an empty stack using a list data structure)

    def push(self, val: int) -> None: # ye function stack mein value ko push karega (this function will push a value onto the stack)
        '''Push a new value onto the stack.'''
        if not self.stack: # agar stack khali hai (if the stack is empty)
            self.stack.apppend((val, val)) # to hum value ko stack mein push karte hain aur uski minimum value bhi wahi hoti hai (we push the value onto the stack and its minimum value is also the same)
            return # agar stack mein pehle se value hai (if there is already a value in the stack)
        
        current_min = self.stack[-1][1] # hum stack ke last element ki minimum value ko nikalte hain (we get the minimum value of the last element in the stack)
        self.stack.append((val, min(val, current_min))) # hum value ko stack mein push karte hain aur minimum value ko update karte hain (we push the value onto the stack and update the minimum value)
        

    def pop(self) -> None: # ye function stack se last element ko pop karega (this function will pop the last element from the stack)
        '''Pop the top value from the stack.'''
        self.stack.pop() # hum stack se last element ko pop karte hain (we pop the last element from the stack)

    def top(self) -> int: # ye function stack ke top element ko return karega (this function will return the top element of the stack)
        '''Get the top value of the stack.'''
        return self.stack[-1][0] # hum stack ke last element ki value ko return karte hain jo [-1][0] position par hoti hai (we return the value of the last element in the stack which is at position [-1][0])

    def getMin(self) -> int: # ye function stack ke minimum element ko return karega (this function will return the minimum element of the stack)
        return self.stack[-1][1] # hum stack ke last element ki minimum value ko return karte hain jo [-1][1] position par hoti hai (we return the minimum value of the last element in the stack which is at position [-1][1])


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()