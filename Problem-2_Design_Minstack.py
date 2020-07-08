# Time Complexity : O(1) - isEmpty, isFull, top, push, pop, getMin.
# Space Complexity : O(n) - n : length of the stack
# Did this code successfully run on Leetcode : Yes (on leetcode, it was slightly different - didnt have isFull, isEmpty and top functions)
# Any problem you faced while coding this : At first I maintained min as a global variable but couldn't handle if the element popped off.
#
#
# Your code here along with comments explaining your approach

class MinStack:

    def __init__(self, capacity):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.curr_size = 0
        self.capacity = capacity

    # Checks if the stack is empty by curr_size global variable
    def isEmpty(self):
        if self.curr_size == 0:
            return True
        else:
            return False

    # Checks if the stack is full by curr_size and capacity global variable
    def isFull(self):
        if self.curr_size == self.capacity - 1:
            return True
        else:
            return False

    # Returns top of the stack if the stack is not empty
    def top(self) -> int:
        if not self.isEmpty():
            return self.stack[-1][0]
        else:
            print("Stack Underflow")

    # Pushes the element into stack if the stack is not overflow
    def push(self, x: int) -> None:
        if self.isFull():
            print("Stack Overflow")
        else:
            if self.curr_size == 1:
                min_elem = x
            else:
                min_elem = min(self.top[1], x)
            self.stack.append((x, min_elem))
            self.curr_size += 1

    # Pops the top element from the stack if the stack is not empty
    def pop(self) -> None:
        if self.isEmpty():
            print("Stack Underflow")
        else:
            self.stack.pop(-1)
            self.current_size -= 1

    # Returns the min value of the entire stack
    def getMin(self) -> int:
        if not self.isEmpty():
            return self.stack[-1][1]
        else:
            return None

