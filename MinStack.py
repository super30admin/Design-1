# Time Complexity = O(1)
# Successfully run and compiled on Leetcode

class MinStack(object):

    def __init__(self):
        self.stk = [] #normal stack
        self.minstk = [] #stack to obtain min value

    def push(self, val):

        if (not self.minstk or (val <= self.minstk[-1])):
            # pushing val to minstk only if
            # minstk is empty or its less than or eq to current top element of minstk
            self.minstk.append(val)

        self.stk.append(val)

    def pop(self):

        if (self.stk[-1] == self.minstk[-1]):
            # popping val from minstk if top element in stk and minstk are same,
            # so that top element remaining in minstk is the minimum
            self.minstk.pop()

        self.stk.pop()

    def top(self):

        return self.stk[-1] #returns top most element from stk

    def getMin(self):

        return self.minstk[-1] #returns top most element from minstk

