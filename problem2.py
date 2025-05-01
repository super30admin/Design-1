#Min Stack#
#Time Complexity O(1)#
#Space Complexity:O(n)
class MinStack(object):

    def __init__(self):
        """
        Initialize two stacks:
         - 'stack' for storing all pushed values
         - 'min_stack' for keeping track of the minimum values at each level
        """
        self.stack = []
        self.min_stack = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        Push the value onto the main stack and push the new minimum
        (either the incoming value or the current min) onto the min_stack.
        """
        self.stack.append(val)
        if not self.min_stack:
            # If min_stack is empty, the new value is the minimum
            self.min_stack.append(val)
        else:
            # Otherwise, compare with current minimum (top of min_stack)
            current_min = self.min_stack[-1]
            self.min_stack.append(min(val, current_min))

    def pop(self):
        """
        :rtype: None
        Remove the top element from both the main stack and the min_stack.
        """
        if self.stack:
            self.stack.pop()
            self.min_stack.pop()

    def top(self):
        """
        :rtype: int
        Return the top element of the main stack.
        """
        return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        Return the top element of the min_stack, which is the current minimum.
        """
        return self.min_stack[-1]



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()


# Example code to run
if __name__ == "__main__":
    min_stack = MinStack()
    
  
    min_stack.push(5)
    min_stack.push(2)
    min_stack.push(10)
    min_stack.push(1)
    
    print("Current top:", min_stack.top())    
    print("Current min:", min_stack.getMin()) 
    
    min_stack.pop()  
    
    print("After pop:")
    print("Current top:", min_stack.top())    
    print("Current min:", min_stack.getMin())   
    
    min_stack.pop()  
    
    print("After another pop:")
    print("Current top:", min_stack.top())    
    print("Current min:", min_stack.getMin())  