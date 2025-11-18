"""
QUESTION
https://leetcode.com/problems/min-stack/description/

"""

#Time Complexity:
# push: O(1)
# pop: O(1)
# top: O(1)
# getMin: O(1)
                 
#Space Complexity: O(n)
#Worst case: O(n+n): O(2n)

class MinStack(object):

    def __init__(self):
        """Initialize the stack and min stack"""
        self.stack = []
        self.min_stack = []

    def push(self, val):
        """
        Insert val into the stack 
        :type val: int
        :rtype: None
        """
        self.stack.append(val)
        #If min stack is empty or if val is lesser than the value in the stack
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)
        

    def pop(self):
        """
        Removing element from stack
        :rtype: None
        """
        if not self.stack:
          return
        val = self.stack.pop()
        if val == self.min_stack[-1]:
          self.min_stack.pop()

    def top(self):
        """
        Return topmost element from stack
        :rtype: int
        """
        if not self.stack:
            return None
        return self.stack[-1]

    def getMin(self):
        """
        Return minimum element from stack
        :rtype: int
        """
        if not self.min_stack:
            return None
        return self.min_stack[-1]
        


# Your MinStack object will be instantiated and called as such:
stack = MinStack()
stack.push(-2)
stack.push(0)
stack.push(-3)

print(stack.getMin())  # -3
stack.pop()
print(stack.top())     # 0
print(stack.getMin())