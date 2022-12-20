# Exercise_2: Design MinStack
# Time Complexity: O(1) for push, pop, top and getMin
# Space Complexity: O(N), where N is the number of elements in the stack
# Successful Run on Leetcode: Yes (https://leetcode.com/problems/min-stack/)
# Challenges: None

# Coding Approach:
# One array is used to store the elements of the stack. Another array is used to store the minimum element at each point in time.
# Push: Append the new element to the stack. If the element to be pushed is less than or equal to the minimum element, then push it to the min array.
# Pop: If the element to be popped is equal to the minimum element, then pop it from the min array. Pop the element from the stack.
# Top: The top element in the stack is the last element in the stack array, so we return it.
# getMin: The last element in the min array is the minimum element at that point in time, so we return it.

class MinStack:

    def __init__(self):
        # Initialize two arrays, one for the stack and one for the minimum element at each point in time
        self.stack = []
        self.min = []

    def push(self, val: int) -> None:
        # Append the new element to the stack
        self.stack.append(val)
        # If the element to be pushed is less than or equal to the minimum element, then push it to the min array
        if not self.min or val <= self.min[-1]:
            self.min.append(val)

    def pop(self) -> None:
        # If the element to be popped is equal to the minimum element, then pop it from the min array
        if self.min[-1] == self.stack[-1]:
            self.min.pop()
        # Pop the element from the stack
        self.stack.pop()

    def top(self) -> int:
        # The top element in the stack is the last element in the stack array, so we return it
        return self.stack[-1]

    def getMin(self) -> int:
        # The last element in the min array is the minimum element at that point in time, so we return it
        return self.min[-1]
        
