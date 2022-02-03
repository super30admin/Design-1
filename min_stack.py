# // Time Complexity : O(1), algorithm runs in constant time
# // Space Complexity :O(n), n is number of elements
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class MinStackSolution:

    def __init__(self):
        
        #initialize main stack
        self.mainStack=[]
        #minimum stack to keep track of min value so far
        self.minStack=[]

    def push(self, val):
        #aapend the value to mainstack  
        self.mainStack.append(val)
        #if minStack is empty
        if not self.minStack:
            self.minStack.append(val)
    #compare top element of the minStack with the val,i
        elif val <= self.minStack[-1]:
             self.minStack.append(val)

    def pop(self):
        poppedVal=self.mainStack.pop()
        #if popped value from mainStack is the same as top value of minStack
        if poppedVal == self.minStack[-1]: 
            self.minStack.pop()

    def top(self):
        return self.mainStack[-1]
    
    def getMin(self):
        return self.minStack[-1]

    def show(self):
        # return self.mainStack
        return self.minStack


s=MinStackSolution()
s.push(6)
s.push(2)
s.push(5)
s.push(1)
print(s.show())
print(s.top())
print(s.getMin())
print(s.pop())
print(s.show())
print(s.getMin())


