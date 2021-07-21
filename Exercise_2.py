"""
Time Complexity:
    - push - O(1)
    - pop - O(1)
    - top - O(1)
    - getmin - O(1)
Space Complexity:
    - Size of the array - dynamic O(n)
YES, The code successfully ran on Leetcode
The problem was on how to have the minimum of the array at the time the x was added.

Approach - My approach is pretty clever, I wanted to store the minimum of the array at every moment of
addition therefore, i went with the idea of making an tuple where the second index in tuple is a
the current minimum at that moment.
"""


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.ans = []
        self.size = 0

    def push(self, x: int) -> None:

        if self.size == 0:
            self.ans.append((x, x))
        else:
            if x < self.getMin():
                self.ans.append((x, x))
            else:
                self.ans.append((x, self.getMin()))
        self.size += 1

    def pop(self) -> None:
        self.ans.pop()
        self.size -= 1

    def top(self) -> int:
        return self.ans[len(self.ans) - 1][0]

    def getMin(self) -> int:
        return self.ans[len(self.ans) - 1][1]

