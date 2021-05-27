
class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        #Initializing two arrays for stack and min_stack 
        self.stack = []
        #Defining the current minimum as positive infinity value
        self.current_min =  float('inf')
        self.min_stack = []
        self.min_stack.append(self.current_min)

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.stack.append(val)
        if not self.min_stack:
            self.min_stack.append(val)
        else:
            self.current_min = min(self.current_min,val)
            self.min_stack.append(self.current_min)
        
    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        self.min_stack.pop()
        self.current_min = self.min_stack[-1]

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.min_stack[-1]


#Using two arrays for defining stack and min_stack and storing the current min in the min_stack 
#Time complexity  is (1)

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()