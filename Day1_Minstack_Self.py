#Design: Implement two stacks; One to push the elements and second
# to maintain the minimum value of elements being pushed.

#Time Complexity:
# Push Operation: O(1)
# Pop Operation: O(1)
# Top Operation: O(1)
# GetMin Operation: O(1)

# Space Complexity:
# Stack: O(n)
# MinStack: O(n)

class MinStack(object):

    def __init__(self):
        self.stack = []
        self.minstack = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.stack.append(val)
        if not self.minstack:
            self.minstack.append(val)
        else:
            self.minstack.append(min(val, self.minstack[-1]))
        # self.minstack.append(val if not self.minstack else min(val,self.minstack[-1]))

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        self.minstack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.minstack[-1]
    

obj = MinStack()
obj.push(-2)
obj.push(-3)
obj.pop()
obj.push(-4)
param_3 = obj.top()
param_4 = obj.getMin()