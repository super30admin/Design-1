# Design a SplStack that supports all the stack operations push, pop, isEmpty, isFull 
# and an operation getMin() which should return minimum element from the SplStack. 
# All these operations must be O(1). To implement this, you should only use standard Stack data structure.

# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class MinStack:

    # Using 2 stacks
    # one stack to store all elements pushed
    # Another stack to keep a list of minimum elements. Element on top is the current minimum element

    # Constructor with a size limit to check if stack is full
    # Initializing 2 stacks
    def __init__(self, size_limit):

        self.min_list = []
        self.list = []
        self.size_limit = size_limit

    # As long as stack is not full, pushing elements on the main stack
    # Checking if the element being pushed is less than or equal to last element on min stack (current min element)
    # Enabling duplicates on min stack to keep track of all past min elements
    # Pushing new element on min stack too if its less than or equal to current min element
    def push(self, val: int) -> None:

        if len(self.list) < self.size_limit:
            self.list.append(val)

            if not self.min_list or val <= self.min_list[-1]:
                self.min_list.append(val)

        # Else cannot push element as stack is full
        else:
            print ("Stack is full")

    # Before popping making sure if its also the min element (on top of min stack)
    # If it is, popping the element from min stack as well
    # Otherwise popping it only from the main stack
    def pop(self) -> None:

        if self.list[-1] == self.min_list[-1]:
            self.min_list.pop()
        
        self.list.pop()
    
    # Returning element on top of min stack which is current min element
    def getMin(self) -> int:
        return self.min_list[-1]

    def isEmpty(self):
        return self.list == []

    # Comparing with size limit to check of stack is full
    def isFull(self):
        return len(self.list) == size_limit

    def show(self):
        return self.list


s = MinStack(5)
s.push('3')
s.push('2')
print(s.getMin())
s.push('1')
s.push('0')
print(s.getMin())
s.pop()
print(s.getMin())
s.push('5')
print(s.show())
