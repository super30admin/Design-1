'''

Time Complexity : O(1)
Space Complexity : O(N), grows linearly with the number of elements being added, get Min() is O(1) though
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes, I spent a considerable amount of time in the push method to pen down the condition to put the current element as the min element,
was using if len(self.stack) <= 0 or not self.getMin(): instead of if len(self.stack) <= 0 and not self.getMin():
'''


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.

        """
        # We want constant time so we are not allowed to iterate the array to get the min
        # the idea is to push the min most found so far to the stack along with the key being               pushed, so the top of the stack will contain the min most element everytime
        # tuple definition - (val, min_most)
        self.stack = []

    def push(self, val: int) -> None:
        # check if the element being added is the very first.
        # else check if the top of the stack is min than the val being put , update the second
        # element if so
        # O(1)
        if len(self.stack) <= 0 and not self.getMin():
            self.stack.append((val, val))
            return

        self.stack.append((val, min(val, self.getMin())))

    def pop(self) -> None:
        # O(1)
        self.stack.pop()

    def top(self) -> int:
        #O(1)
        return self.stack[-1][0]

    def getMin(self) -> int:
        #O(1)
        # we can obtain the last element using list slicing [-1] only if the stack contains               elements, hence the check
        if len(self.stack) > 0:
            return self.stack[-1][1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()