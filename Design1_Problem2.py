# Time Complexity : O(1) for getting Min and push and pop
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach : a min value where I compare with the already existing minimum value and update it accordingly

#Optimized
import sys
class MinStack(object):

    def __init__(self):
        self.stack = []
        self.min_val = sys.maxint

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if val <= self.min_val:
            self.stack.append(self.min_val)
            self.min_val = val
        self.stack.append(val)

    def pop(self):
        """
        :rtype: None
        """
        if self.min_val == self.stack.pop():
            self.min_val = self.stack[-1]
            self.stack.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]
        
    def getMin(self):
        """
        :rtype: int
        """
        return self.min_val



#BruteForce
# class MinStack(object):

#     def __init__(self):
#         self.stack = []
#         self.min_stack = [sys.maxint]

#     def push(self, val):
#         """
#         :type val: int
#         :rtype: None
#         """
#         self.stack.append(val)
#         if self.min_stack[-1] > val:
#             self.min_stack.append(val)
#         else:
#             self.min_stack.append(self.min_stack[-1])

#     def pop(self):
#         """
#         :rtype: None
#         """
#         self.stack.pop()
#         # if top == self.min_stack[-1]:
#         self.min_stack.pop()

#     def top(self):
#         """
#         :rtype: int
#         """
#         return self.stack[-1]
        
#     def getMin(self):
#         """
#         :rtype: int
#         """
#         return self.min_stack[-1] if self.min_stack[-1] != sys.maxint else 0


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()