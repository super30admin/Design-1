"""
Leetcode: https://leetcode.com/problems/min-stack/
TC: see below, SC: O(2N) - two arrays used for array and minimum array
Topic - Dynamic Array, Stack
Challenge: Getting getMin() in constant time (used another stack for saving minimums)

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.


Example 1:

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


Constraints:

-2^31 <= val <= 2^31 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin
"""


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

class MinStack:

    def __init__(self):
        self.arr = [None] * (3 ** 10)
        self.lastElementIndex = -1
        self.minimumList = [None] * (3 ** 10)
        self.minimumListLastIndex = -1

    # TC - O(1), SC - O(1)
    def push(self, val: int) -> None:
        # maintain a minimum stack list when pushing element. Only push if the new value is less or equal
        if self.minimumListLastIndex == -1:
            self.minimumListLastIndex += 1
            self.minimumList[self.minimumListLastIndex] = val
        elif val < self.minimumList[self.minimumListLastIndex]:
            self.minimumListLastIndex += 1
            self.minimumList[self.minimumListLastIndex] = val

        # return popped element
        self.lastElementIndex += 1
        self.arr[self.lastElementIndex] = val

    # TC- O(1), SC- O(1)
    def pop(self) -> None:
        poppedElement = self.arr[self.lastElementIndex]

        # also pop the element if they are in minimum stack
        if poppedElement == self.minimumList[self.minimumListLastIndex]:
            self.minimumListLastIndex -= 1

        self.lastElementIndex -= 1
        return poppedElement

    # TC- O(1), SC- O(1)
    def top(self) -> int:
        return self.arr[self.lastElementIndex]

    # TC- O(1), SC- O(1)
    def getMin(self) -> int:
        return self.minimumList[self.minimumListLastIndex]


# obj = MinStack()
# obj.push(-2)
# obj.push(0)
# obj.push(-3)
# print(obj.pop())
# print(obj.top())
# print(obj.getMin())
