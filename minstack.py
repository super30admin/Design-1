import sys
class MinStack(object):

#Created a Minstack with attributes of list and an minimum to hold the minimum value
    def __init__(self):
        self.stack = []
        self.minimum = sys.maxsize - 1
        """
        initialize your data structure here.
        """
# while pushing into stack i just check whether element is less than minimum, if so I push the current minimum and update the minimum to new minimum and push the element
# this is to keep track of the previous minimum

    def push(self, x):
        if x <= self.minimum:
            self.stack.append(self.minimum)
            self.minimum = x
        self.stack.append(x)
        """
        :type x: int
        :rtype: None
        """
# While popping i compare the element pooped with the current minimum, if it equals to current minimum, i pop again to update the minimum to previous minimum
    def pop(self):
        element = self.stack.pop()
        print(self.stack)
        if element == self.minimum:
            temp = self.stack.pop()
            self.minimum = temp
        """
        :rtype: None
        """

# return top element of the stack
    def top(self):
        """
        :rtype: int
        """
        return self.stack[len(self.stack)-1]

# return minimum element of the stack
    def getMin(self):
        """
        :rtype: int
        """
        return self.minimum



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
