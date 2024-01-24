#Time Complexity: O(1) for all the operations:- push, pop, top and getMin in both the methods
#Space Complexity: O(n) for Method 1 as we are utilizing extra stack space to maintain the min element. O(1) for Method 2 as we are using only extra variables.

#Both solutions running on Leetcode

from collections import deque
# Uses 1 stack and 1 Minstack
# class MinStack:

#     def __init__(self):
#         self.stack = deque()
#         self.minstack = deque()
#         self.minstack.append((2**31) - 1)

#     def push(self, val: int) -> None:
#         self.stack.append(val)
#         if val <= self.minstack[-1]:
#             self.minstack.append(val)        

#     def pop(self) -> None:
#         if self.stack:
#             item = self.stack.pop()
#             if item == self.minstack[-1]:
#                 self.minstack.pop()

#     def top(self) -> int:
#         if self.stack:
#             return self.stack[-1]
        

#     def getMin(self) -> int:
#         if self.minstack:
#             return self.minstack[-1]

class MinStack:

    def __init__(self):
        self.stack = deque() #create the stack
        self.min = (2**31) - 1 #set initial min

    def push(self, val: int) -> None:       
        if val <= self.min: #check if input item is less than min or not
            self.stack.append(self.min) #push the current min into the stack 
            self.min =val  #set the new min
        self.stack.append(val) #put the value in the stack

    def pop(self) -> None:
        if self.stack: #check if stack is empty 
            if self.stack.pop() == self.min: # if popped element is the min
                self. min = self.stack.pop() # set the min to the previous min


    def top(self) -> int: 
        if self.stack: #check if the stack is empty
            return self.stack[-1] #return the top of the stack
        

    def getMin(self) -> int:
        return self.min #return the current min in the stack