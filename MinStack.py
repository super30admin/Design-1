"""
Rasika Sasturkar
Time Complexity: O(1)
Space Complexity: O(1)
"""

# import library
import math


class MinStack:

    def __init__(self):
        """
        Constructor - initialized 2 stacks and a minimum value variable
        """
        self.main_stack = []
        self.min_stack = [math.inf]
        self.min_value = math.inf

    def push(self, val: int) -> None:
        """
        Check the value being pushed is smaller than the minimum value
        Push the value to main stack, whereas push the minimum value to min stack
        """
        self.min_value = min(val, self.min_value)
        self.main_stack.append(val)
        self.min_stack.append(self.min_value)

    def pop(self) -> None:
        """
        Pop elements from both stacks
        Set minimum value to the top of min stack
        """
        self.main_stack.pop()
        self.min_stack.pop()
        self.min_value = self.min_stack[-1]

    def top(self) -> int:
        """
        Get the element at the top of main stack
        """
        return self.main_stack[-1]

    def getMin(self) -> int:
        """
        We find the minimum value
        """
        return self.min_value


def main():
    """
    Main function - an example from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    print(minStack.getMin())  # return -3
    minStack.pop()
    print(minStack.top())  # return 0
    print(minStack.getMin())  # return -2


if __name__ == "__main__":
    main()
