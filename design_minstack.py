# Time Complexity :push:- O(1) pop:-O(1) top- O(1) getmin:- O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : At first I thought of using a heap to keep track of the minimum element but that would give me O(logn) time
#  in the worst case
# to get the minimum element. So had to think of a different approach
# Idea:- Everytime I push an element to the stack append the minimum element
#  i have seen till now with it. So i append an array containing two values:- the value itself,and the minimim element seen till now.
#  So for returning minimum element at any
# point just return the 1st index of the top element on the stack
import collections
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.my_stack=collections.deque([])
        

    def push(self, x: int) -> None:
        if len(self.my_stack)==0:
            self.my_stack.append([x,x])
        else:
            min_element=min(x,self.my_stack[-1][1])
            self.my_stack.append([x,min_element])
            

    def pop(self) -> None:
        # LC gurantees pop wouldn't be called on empty stack, so not checking
        self.my_stack.pop()
        

    def top(self) -> int:
        # LC gurantees top wouldn't be called on empty stack, so not checking
        return self.my_stack[-1][0]
        

    def getMin(self) -> int:
        # LC gurantees getMin wouldn't be called on empty stack, so not checking
        return self.my_stack[-1][1]