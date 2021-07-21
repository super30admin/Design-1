# Time Complexity :
#   Creation : O(size) size is 30000 here.
#   Push : O(1)
#   Pop : O(1)
#   Top : O(1)
#   getMin: O(1)
# Space Complexity : O(size), size=30000
# Did this code successfully run on Leetcode : Yes. Another implementation without using the top and using append, and pop inbuilt functions was faster.
# Any problem you faced while coding this : Hardcoding the ranges causes issues which is fixed by using append and pop functions of a python list.


class MinStack:

    def __init__(self):
        """
        Create empty stack of tuples where 0th index is the element and the 1st index is the MINIMUM element so far.  
        """
        self.top_ = -1
        self.stack = [(0,0) for _ in range(30000)]

    def push(self, val: int) -> None:
        if self.top_ == -1:
            # No elements in the stack so insert the value and set it as the global minimum.
            self.top_ += 1
            self.stack[self.top_] = (val, val)
        else:
            # Update the minimum if the inserted element is smaller than the previous global minimum (1st index of the previous top tuple in the stack)
            self.top_ +=1
            if val < self.stack[self.top_-1][1]:
                self.stack[self.top_] = (val, val)
            else:
                self.stack[self.top_] = (val, self.stack[self.top_-1][1])

    def pop(self) -> None:
        # decrement the top to "delete" the top element
        if self.top_ == -1:
            raise IndexError("Underflow Error.")
        else:
            self.top_ -= 1

    def top(self) -> int:
        # Return the 0th index of the top of the stack which is the top element
        return self.stack[self.top_][0]

    def getMin(self) -> int:
        # Return the 1st index of the top of the stack which is the minimum upto the point i.e. the global minimum.
        return self.stack[self.top_][1]

