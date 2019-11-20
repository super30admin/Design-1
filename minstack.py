# Create two stacks, one for input values and one for minimum values.
# Store a global variable to store minimum value. Initially assign it to infinity.
# If the input value is less than min value, change the min value to new value and push them in both the stacks.
# At pop, pop both the stacks and change the minimum value to to of min stack.
# Time Complexity: init- O(1), push- O(1), pop- O(1), top- O(1), getMin - O(1)
# Space Complexity: O(2n) n for each stack = O(n)
class MinStackOne(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.minValue = float('inf')
        self.minStack = []
        self.minStack.append(self.minValue)
        self.stack = []
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        
        if x < self.minValue:
            self.minValue = x
        self.stack.append(x)
        self.minStack.append(self.minValue)
        

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        self.minStack.pop()
        self.minValue = self.minStack[-1]
        

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.minValue