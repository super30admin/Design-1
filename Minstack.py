class MinStack:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.main_stack = []  # Stack to store elements
        self.min_stack = []   # Stack to track minimum values
    def push(self, val):
        """
        Pushes the element val onto the stack.
        :type val: int
        :rtype: None
        """
        self.main_stack.append(val)  # Push the element onto the main stack
        # Update the minimum stack with the new minimum value if necessary
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)
    def pop(self):
        """
        Removes the element on the top of the stack.
        :rtype: None
        """
        if self.main_stack:
            # Check if the element being removed is the current minimum
            if self.main_stack[-1] == self.min_stack[-1]:
                self.min_stack.pop()
            self.main_stack.pop()
    def top(self):
        """
        Gets the top element of the stack.
        :rtype: int
        """
        if self.main_stack:
            return self.main_stack[-1]
    def getMin(self):
        """
        Retrieves the minimum element in the stack.
        :rtype: int
        """
        if self.min_stack:
            return self.min_stack[-1]
# Example usage:
minStack = MinStack()
minStack.push(-2)
minStack.push(0)
minStack.push(-3)
print(minStack.getMin())  # Should return -3
minStack.pop()
print(minStack.top())     # Should return 0
print(minStack.getMin())  # Should return -2
