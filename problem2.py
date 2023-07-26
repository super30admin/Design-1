# Time Complexity : O(1) for all operations.
# Space Complexity : O(1) as we are using a single stack.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Initially I used two stacks but then after learning Raj sir's approach, I used a single stack.


# Your code here along with comments explaining your approach
# Design MinStack using array
# We use a single stack to store the elemetns and a variable to track the minimum element. We set the minimum initially to infinity.
# For push operation, we first compare the element to be pushed with the current min element. If it less than equal to the element to be pushed, the we push the current min in the stack and
# update the min to the element to be pushed. Then we push the element to be pushed in the stack.

# for pop operation, we check if the element which is to be popped is the current min value, if yes then we need to get the previous min which is the element below the current min and to
# do so we pop the top element first and assign it to min

# Top operation will return the the top element (in our case it is the last element as we are using an array) from the stack
# getMin operation will return the current min value which we are tracking using min variable. 

import sys

class MinStack:
    def __init__(self):
        self.stack = [] # Array to implement the min stack
        self.min = int(sys.maxsize) # setting the min to infinity initially. 


    def push(self, value: int):
        
        # If value is less than equal to the current min - we add the min to stack and update the min to the value
        if self.min >= value:
            self.stack.append(self.min)
            self.min = value

        # Push the new value into the stack
        self.stack.append(value)


    def pop(self, value: int):
        # We will store the popped value first so that we can compare it with the current min

        popd = self.stack.pop()

        # compare the popped element with the current min - if yes update the new min to the next popped element, in this way we get the previous min
        if popd == self.min:
            self.min = self.stack.pop()


    def top(self):
        # return the top of the stack (last element as we are using an array)
        return self.stack[-1]

    def getMin(self):
        return self.min   # As we are updating and tracking the min everytime


        