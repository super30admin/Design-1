# Using one Stack instead of 2.
class MinStack(object):
    
 #One stack Solution is as below.
# ''' lets consider minimum to be infinity by setting it to sys.maxsize
# Now we maintain the numbers that are pusged into the tsack and their minimums in pairs or as a group. So according to the example, we have to first push -2, check if -2< than the current minimum which is infinity. It is, so we push current minimu, and -2 adn set the curret minimum to min(current minimum,-2)

# Nect we push 0, so the value 0 is not less than current minimum which is now -2, so we just push the value.and current minimum does not change and is still -2

# next we push -3, the value -3 is less than current minimum which is -2, so we need to push the previous minimum -2 and also -3 and set the new minimum to min(-2,-3) = -3'

# So fot the pop operation, since we are maintaining the values and their numbers in pairs, we know when the value to be popped is equal to the current minimum would mean this where the minimums changes and this value to be popped will definitely have a value below it as a pair. So when the value to be popped is equal to the current minimum we pop another value wand set the second popped value to be the cuurent minimum.'''

    def __init__(self):
        """
        initialize your data structure here.
        """
        
        self.minStack = []
        self.minimum = sys.maxsize

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        
        if x > self.minimum:
            self.minStack.append(x)
            self.minimum = min(self.minimum,x)
        elif x <= self.minimum:
            self.minStack.append(self.minimum)
            self.minStack.append(x)
            self.minimum = min(self.minimum,x)
            
    

    def pop(self):
        """
        :rtype: None
        """
        popped = self.minStack.pop() #this is a check to see this where a minimum changed
        if popped == self.minimum:
            self.minimum = self.minStack.pop()
            
        

    def top(self):
        """
        :rtype: int
        """
        return self.minStack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.minimum


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()