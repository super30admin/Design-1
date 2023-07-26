''' Creating a class called MinStack'''
class MinStack:

    ''' Defining the constructor method that gets called when a new object 
of this class is instantiated'''
    def __init__(self):
      ''' Initializing an empty list to use as the main stack'''
        self.stack=[]
        ''' Setting initial minimum value as maximum int value'''
        self.min = int(sys.maxsize)

    ''' Defining the method to push a value onto the stack'''
    def push(self, val: int) -> None:
        ''' Checking if the value being pushed is less than or equal to 
the current minimum value in the stack'''
        if val <= self.min:
        ''' If so, pushing the current minimum value onto the stack 
before pushing the new value'''
            self.stack.append(self.min)
            # Then, updating the current minimum value
            self.min = val
        # Regardless, always pushing the new value onto the stack
        self.stack.append(val)

    # Defining the method to pop a value from the stack
    def pop(self) -> None:
        # Popping the top value from the stack
        popped = self.stack.pop()
        # Checking if the popped value is the current minimum
        if popped == self.min:
            # If so, popping the next value from the stack, which is the 
previous minimum value, and setting it as the new minimum
            self.min= self.stack.pop()

    # Defining the method to get the top value of the stack
    def top(self) -> int:
       ''' Returning the last item in the list, which represents the top 
of the stack'''

        return self.stack[-1]

    # Defining the method to get the current minimum value in the stack
    def getMin(self) -> int:
        # Returning the current minimum value
        return self.min


