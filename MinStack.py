# Time Complexity : O(1) for push, pop, top and get_min
# Space Complexity : O(n) [In reality O(2n)]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach

def __init__(self):
    """
    initialize your data structure here.
    """
    self.stack = []
    self.mini = float("inf")


def push(self, val: int) -> None:
    """

    :param self: stack
    :param val: Element value to be pushed onto stack
    :return: void
    function pushes the element onto stack and the minimum element too
    only if the element is less than or equal to the minimum
    """
    if val <= self.mini:
        self.stack.append(self.mini)
        self.mini = val
    self.stack.append(val)


def pop(self) -> None:
    """
    Pops the top element from the stack
    :param self: stack
    :return: void
    When popping the element the function checks if the element being
    popped is equal to minimum element, which means we are popping the minimum,
    if yes, pop the element and set the top element to new minimum,
    else, just pop the element
    """
    if self.mini == self.stack[-1]:
        self.stack.pop()
        self.mini = self.stack[-1]
    self.stack.pop()


def top(self) -> int:
    """
    :param self: stack
    :return: top element
    """
    return self.stack[-1]


def getMin(self) -> int:
    return self.mini

