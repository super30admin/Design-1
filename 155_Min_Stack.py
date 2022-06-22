'''

## Problem 2: Design MinStack (https://leetcode.com/problems/min-stack/)

## Author: Neha Doiphode
## Date  : 06-21-2022

## Title:
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

## Description:
    Implement the MinStack class:
        MinStack() initializes the stack object.
        void push(int val) pushes the element val onto the stack.
        void pop() removes the element on the top of the stack.
        int top() gets the top element of the stack.
        int getMin() retrieves the minimum element in the stack.

## Example 1:
    Input
        ["MinStack","push","push","push","getMin","pop","top","getMin"]
        [[],[-2],[0],[-3],[],[],[],[]]

    Output
        [null,null,null,null,-3,null,0,-2]

    Explanation
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2

## Constraints:
    -231 <= val <= 231 - 1
    Methods pop, top and getMin operations will always be called on non-empty stacks.
    At most 3 * 104 calls will be made to push, pop, top, and getMin.
'''

'''
Approach 1: Using two stacks

Time complexity : O(1), constant time is required to get minimum value, push, pop operations
Space complexity: O(n), Auxiliary stack is used to store min elements.
'''

class MinStack_1:
    def __init__(self):
        self._main_stack = []
        self._min_stack = []
        self._min_stack.append(float('inf'))

    def push(self, val: int) -> None:
        self._main_stack.append(val)
        self._min_stack.append(min(val, self._min_stack[-1]))

    def pop(self) -> None:
        self._main_stack.pop()
        self._min_stack.pop()

    def top(self) -> int:
        return self._main_stack[-1]

    def getMin(self) -> int:
        return self._min_stack[-1]

'''
Approach 2: Using one stack

Time complexity : O(1), constant time is required to get minimum value, push, pop operations
Space complexity: O(n), main stack will store elements and minimum values. So space required is same as we ignore constants.

'''
from typing import List

class MinStack:

    def __init__(self):
        self._stack = []
        self._min = float('inf')
        self._stack.append(self._min)

    def push(self, val: int) -> None:
        if val <= self._min:
            self._stack.append(self._min)
            self._stack.append(val)
            self._min = val
        else:
            self._stack.append(val)

    def pop(self) -> None:
        if self._stack.pop() == self._min:
            self._min = self._stack.pop()

    def top(self) -> int:
        return self._stack[-1]

    def getMin(self) -> int:
        return self._min

    def getStack(self) -> List[int]:
        return self._stack

# Driver code
minStack = MinStack()
minStack.push(-2)
minStack.push(0)
minStack.push(-3)
print(f"Current stack: {minStack.getStack()}")
print(f"Current minimum: {minStack.getMin()}") # return -3
minStack.pop()
minStack.top()    # return 0
print(f"Current stack: {minStack.getStack()}")
print(f"Current minimum: {minStack.getMin()}") # return -2
