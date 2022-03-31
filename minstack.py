#Problem 2: Minstack
# // Time Complexity : O(1)
# // Space Complexity : O(N) as it is adding all the values to the stack
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



class Minstack():
    def __init__(self):
        self.stack = []             #where all the data goes
        self.min=None               #keeps track of the minimum value

    def push(self, value):
        if( self.min == None or value < self.min):
            self.min = value
        self.stack.append((value, self.min))            #append both the value and the minimum value at that time to the list

    def pop(self):
        self.stack.pop()
        if len(self.stack)==0:                          #after popping an element, check if the stack is empty or not
            self.min = None
        else:
            self.min = self.stack[-1][1]                               #if the stack isnt empty, update the minimum value

    def isEmpty(self):
        return self.stack == []

    def getMin(self):
        return ( self.min)

#testing
minStack = Minstack()
minStack.push(-2)
minStack.push(0)
minStack.push(-3)
print(minStack.getMin()) #// return -3
minStack.pop()
print(minStack.getMin()) #// return -2

