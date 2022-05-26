# Time Complexity : O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No



# Your code here along with comments explaining your approach

class SplStack:

    def __init__(self, maxSize = 6):
        #Creating two list one for stack and another for min stack
        self.stack = list()
        self.min = list(['inf'])
        self.maxSize = maxSize

    def push(self, val):
        #Checking if value entered is less than or equal to minimum
        #If yes then adding it to min stack and also normally add to
        #main stack
        if(val <= float(self.min[-1])):
            self.min.append(val)

        self.stack.append(val)
        
        
    def pop(self):
        #Seeing if top value in both stack is same then poping it out
        #and normally poping out
        if(self.stack[-1] == self.min[-1]):
            return self.min.pop()
        return self.stack.pop()


    def isEmpty(self):
        #If length of stack is 0 returning True else Flase
        if(len(self.stack)==0):
            return True
        else:
            return False
        
        
    def isFull(self):
        #Here 1st seting maxSize then checking length and maxSize same or not
        if(len(self.stack)==self.maxSize):
            return True
        else:
            return False
    
    def top(self):
        #Returning top value of stack
        return self.stack[-1]
      
        
    def getMin(self):
        #Returning top value in min stack
        return self.min[-1]



s = SplStack()
s.push(1)
s.push(2)
s.push(3)
s.push(4)
print(s.pop())
print(s.isEmpty())
print(s.top())
print(s.getMin())
