#   Time Complexity : Push fuunction - O(1), pop function - O(1), top function - O(1), getMin function - O(1)

#   Space Complexity : O(n)
#   Did this code successfully run on Leetcode : Yes
#   Any problem you faced while coding this : No.
#   Your code here along with comments explaining your approach

class MinStack:

    # Initializing both the stack and the min stack.
    def __init__(self):
        self.stack = []
        self.minStack = []
        
    # Pushing the given value into both stack and into min stack if the top element of the min stack is greater than the
    # current element. If not, then we will push the top element of the stack again into the stack to 
    # keep track of the current minimum element of the stack.
    def push(self, val: int) -> None:
        self.stack.append(val)
        val = min(val, self.minStack[-1] if self.minStack else val)
        self.minStack.append(val)

    # Popping the top element of the stack along with the top element of the min stack to make sure we are keeping track
    # of the minimum element in the min stack.
    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()

    # Returning the top element of the stack.
    def top(self) -> int:
        return self.stack[-1]

    # Returning the minimum element of the stack, which is returning the top element of the stack.
    def getMin(self) -> int:
        return self.minStack[-1]