'''
Min stack buiilding is just like the regular stack design, instead we use another stack to maintain the min variable, since since append operation, we comapare it with current 
min value, we can set the lowest of the two and append it to the min stack, the complexity for O(1) since we can aceess elements directly but space will be O(2n) = O(n)
for storing 2 stacks
'''

class MinStack(object):

    def __init__(self):
        self.stack = []
        self.minstack = []
        self.min = float("inf")
        self.minstack.append(self.min)


    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.min = min(self.min, val)
        self.stack.append(val)
        self.minstack.append(self.min)
        

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        self.minstack.pop()
        self.min = self.minstack[-1]

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
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()