class MinStack(object):

# 2stacks
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min_stack = []

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        #push to main stack
        #push to min stack only if that is empty or its top elemnt is more than new element
        self.stack.append(x)
        if not self.min_stack or x <= self.min_stack[-1]:
            self.min_stack.append(x)

    def pop(self):
        """
        :rtype: void
        """
        if not self.stack:
            return None
        #pop from main stack and pop from min stack only if top values are equal in both stacks
        ans = self.stack.pop()
        if ans == self.min_stack[-1]:
            self.min_stack.pop()

        return ans

    def top(self):
        """
        :rtype: int
        """
        #return fro main stack
        if not self.stack:
            return None
        return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        #return from min stack
        if not self.min_stack:
            return None
        return self.min_stack[-1]

#O(1) all operations
#O(N) additional min stack



#???????????????????#
#1 stack
# class MinStack(object):
# O(N)
# #1 stacks O(1) auxiliary space

#     def __init__(self):
#         """
#         initialize your data structure here.
#         """
#         self.stack = []
#         self.mini =float("inf")

#     def push(self, x):
#         """
#         :type x: int
#         :rtype: void
#         """
#         if x<=self.mini:
#             self.stack.append(self.mini)
#             self.mini=x
#         self.stack.append(x)
        

#     def pop(self):
#         """
#         :rtype: void
#         """
#         ans = self.stack.pop()
#         if ans==self.mini:
#             self.mini=self.stack.pop()

        

#     def top(self):
#         """
#         :rtype: int
#         """
#         return self.stack[-1]

#     def getMin(self):
#         """
#         :rtype: int
#         """
#         return self.mini