# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Calculating the time and space complexities 
class MinStack():

    def __init__(self):
        """
        initialize your data structure here.
        """
        #initializing the stack
        self.obj=[] 
        #initializing the min variable as the maximum integer value possible
        self.min= float('inf')
    
    #check if the stack is empty
    def isEmpty():
        if self.obj==[]:
            return True
        else:
            return False
        

    def push(self, x):
        
        """
        :type x: int
        :rtype: None
        """
        #if the stack is empty, assign the value as min and push it into the stack
        #if self.obj==[]:
            #self.obj.append(x)
            #self.min=x
        
        #if the stack is not empty
        #else:
        if x <= self.min:
            self.obj.append(self.min) #add the old min to the stack
            self.min=x #update the min value 
            self.obj.append(x) #add the new element to the stack
        else:
            self.obj.append(x)
            

    def pop(self):
        """
        :rtype: None
        """
        #check if the stack is empty
        if self.obj==[]:
            print ("trying to pop from an empty list")
            
        #if stack is not empty double pop and update the min value
        else:
            poppedItem=self.obj.pop()
            if poppedItem==self.min:
                self.min=self.obj.pop()

    def top(self):
        """
        :rtype: int
        """
        if self.obj==[]:
            print ("nothing to refer")
        else:
            return self.obj[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
