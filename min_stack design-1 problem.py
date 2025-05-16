"""
We use a custom MinStack to efficiently retrieve the minimum element in constant time, O(1), alongside regular stack operations like push, pop, and top.
A normal stack doesn't keep track of the minimum, so finding the min would take O(n) time.
To overcome this, we maintain a second stack (min_stack) that keeps track of the current minimum at each level of the main stack.

So basically to amortize O(n) to get O(1)
"""


"""
Time Complexity : O(1) 
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes, it did
Any problem you faced while coding this :
At first, I forgot to initialize the two internal stacks (`stack` and `min_stack`), which caused errors.
Once initialized properly and the condition checks were added for getMin logic, the code worked as expected.
"""


class MinStack:
    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, val):
        self.stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)

    def pop(self):
        popped = self.stack.pop()
        if popped == self.min_stack[-1]:
            self.min_stack.pop()

    def reset_stack(self):
        self.stack = []
        self.min_stack = []

    def top(self):
        return self.stack[-1]

    def getMin(self):
        return self.min_stack[-1]
