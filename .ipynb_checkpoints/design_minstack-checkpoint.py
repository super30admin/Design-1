# Program name - Design 1 - Implement minstack in python
# Author - Prajakta Pardeshi cohort Nov2021

# Time complexity for all the operations-
# put - O(1) since we use the key to put
# get - O(1) since we fetch with single key



# Space complexity for hashmap is O(n) where n is the number of elements with key value pair

class MinStack(object):

    def __init__(self):
        self.stack = []
        self.min = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.stack.append(val)
        
        if len(self.min) == 0:
            self.min.append(val)
        elif len(self.min) > 0 and val <= self.min[-1]:
            #Checking val <= min is necessary in case the same min value is pushed multiple times. 
            self.min.append(val)
        

    def pop(self):
        """
        :rtype: None
        """
        val = self.stack.pop()
        #The value can only possibly be on the min stack, if it was a new (or ==) minimum when it was pushed.
        if val == self.min[-1]:
            self.min.pop()
        return val
        

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.min[-1]
        


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(1)
obj.push(5)
obj.push(6)
obj.push(2)
obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()
