# 155. Min Stack
# // Time Complexity : push - O(1), pop-O(1), top-O(1), getMin-O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

class MinStack:
    def __init__(self):
        # implementing stack using lists
        self.stack = []
        # variable to keep track of size
        self.size = 0
        # stack for storing minimums
        self.min_stack = []

    def push(self, val: int):
        # push val
        self.stack.append(val)
        # if min_stack has the same value
        if not self.min_stack or val <= self.min_stack[-1]:
            # pop it
            self.min_stack.append(val)
        # adjust size coz pushed
        self.size += 1

    def pop(self):
        # if stack is empty
        if self.size <= 0:
            return
        # stack last element and min_stack last element same
        if self.min_stack[-1] == self.stack[-1]:
            # pop out min_stack element
            self.min_stack.pop()
        # then pop out stack element
        self.stack.pop()
        # adjust size coz popped
        self.size -= 1

    def top(self):
        # if stack is not empty
        if self.size > 0:
            # send last element
            return self.stack[-1]

    def getMin(self):
        # return last element of min)stack for minimum element
        return self.min_stack[-1]


# obj = MinStack()
# obj.push(1)
# obj.push(2)
# obj.push(3)
# obj.push(-10)
# obj.push(-11)
# obj.pop()
# print(obj.getMin())
