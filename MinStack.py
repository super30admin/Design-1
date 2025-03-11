# 155. Min Stack

# Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

# Implement the MinStack class:

#     MinStack() initializes the stack object.
#     void push(int val) pushes the element val onto the stack.
#     void pop() removes the element on the top of the stack.
#     int top() gets the top element of the stack.
#     int getMin() retrieves the minimum element in the stack.

# You must implement a solution with O(1) time complexity for each function.

# Approach:
# - Uses two stacks: one for storing all elements, and another for tracking minimum values.
# - The minStack keeps track of the minimum value at each state of the main stack.
# - All operations (push, pop, top, getMin) are designed to run in O(1) time complexity.

# Time Complexity:
# - All operations: O(1)

# Space Complexity:
# - O(n) where n is the number of elements in the stack

# Did this code successfully run on Leetcode : YES

class MinStack(object):

    def __init__(self):
        self.stack = [] # Main stack to store all elements
        self.minStack = [] # Auxiliary stack to track minimum values

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.stack.append(val) # Add the new value to the main stack
        
        # If minStack is empty, use val as minimum
        if self.minStack:
            # If minStack is NOT empty, use the topp of the minStack ans minimum value
            min_val = self.minStack[-1]
        else:
            # If minStack is empty, use val as minimum
            min_val = val

        # Calculate the new minimum value compare val with the current minimum  
        val = min(val, min_val)  

         # Add the new minimum to the minStack
        self.minStack.append(val)

    def pop(self):
        """
        :rtype: None
        """
        # Remove the top element from the main stack
        self.stack.pop() 
        # Remove the top element from the minimum stack
        # This keeps both stacks in sync
        self.minStack.pop() 

    def top(self):
        """
        :rtype: int
        """
        # Return the last element (top) of the main stack
        return self.stack[-1]
        
    def getMin(self):
        """
        :rtype: int
        """
        # Return the last element of minStack, which is the current minimum
        return self.minStack[-1]