# Maintain two stacks - minSt and Stack. when a new value is to be pushed, 
# the min is taken and pushed into minSt and the value is pushed to stack. 
# During pop, the operation is performed in both the stacks

# Time complexity : O(1)
# Space complexity: O(n)


class MinStack(object):

    def __init__(self):
        self.minst = []
        self.stack=[]
        self.min = float('inf')

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.min = min(val, self.min)
        self.stack.append(val)
        self.minst.append(self.min)
        

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        self.minst.pop()
        self.min = self.minst[-1] if len(self.minst)>0 else  float('inf')

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.minst[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()




# One stack is maintained. During each push operation, the previous min value 
# is pushed if the min value is lesser than the value. The min is then updated 
# with the new min value and then the value is pushed. During pop, if the poppede
#  valus is the same as min, we pop again and update min.

# Time complexity : O(1)
# Space complexity: O(n)

class MinStack(object):

    def __init__(self):
        self.stack = []
        self.min = float('inf')
      


    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if (val<=self.min):
            self.stack.append(self.min)
            self.min=val
        self.stack.append(val)
        
    def pop(self):
        """
        :rtype: None
        """
        p = self.stack.pop()
        if p==self.min:
            self.min = self.stack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()