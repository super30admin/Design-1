from math import inf


class MinStack:
    """
    Using single stack
    Time Complexity: O(n)
    Space Complexity: There are 2n elements in the stack but in Big O terms O(n)
    """

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = inf

    def push(self, x: int) -> None:
        if x <= self.min:
            self.stack.append(self.min)
            self.min = x
        self.stack.append(x)

    def pop(self) -> None:
        if self.stack.pop() == self.min:
            self.min = self.stack.pop()

    def top(self) -> int:
        if self.stack:
            return self.stack[-1]

    def getMin(self) -> int:
        return self.min


# from math import inf
#
# class MinStack:
#     """
#         Two stack solution
#     """
#
#     def __init__(self):
#         """
#         initialize your data structure here.
#         """
#         self.stack = []
#         self.min_stack = [inf]
#
#     def push(self, x: int) -> None:
#         self.stack.append(x)
#         self.min_stack.append(min(x, self.getMin()))
#
#     def pop(self) -> None:
#         if self.stack:
#             self.stack.pop()
#             self.min_stack.pop()
#
#     def top(self) -> int:
#         if self.stack:
#             return self.stack[-1]
#
#     def getMin(self) -> int:
#         if self.min_stack:
#             return self.min_stack[-1]

# class MinStack:
#     """
#     // Time Complexity :
#                 O(n)
#     // Space Complexity :
#                 O(n)
#     // Did this code successfully run on Leetcode :
#         Yes
#     // Any problem you faced while coding this :
#         Took to time to dice to store the min in tuple.
#         I was initially storing the min in a local variable and recalculating each time
#     // Your code here along with comments explaining your approach
#         We have a list of tuples. Where the first index is the value in the stacj
#         and the second index stores the current min value until that value in the stack.
#         When ever we insert a new value we compare with the last inserted values min value in
#         the tuple and insert the lowest.
#     """
#
#     def __init__(self):
#         """
#             Time Complexity: O(1)
#             Space Complexity: O(1)
#         """
#         self.stack = []
#
#     def push(self, x: int) -> None:
#         """
#             n is the number of elements in the list
#             Time Complexity: O(n)
#             Space Complexity: O(1)
#         """
#         if self.stack:
#             self.stack.append((x, min(x, self.getMin())))
#         else:
#             self.stack.append((x, x))
#
#     def pop(self) -> None:
#         """
#             Time Complexity: O(1)
#             Space Complexity: O(1)
#         """
#         if self.stack:
#             self.stack.pop()
#
#     def top(self) -> int:
#         """
#             Time Complexity: O(1)
#             Space Complexity: O(1)
#         """
#         if self.stack:
#             return self.stack[-1][0]
#
#     def getMin(self) -> int:
#         """
#             Time Complexity: O(1)
#             Space Complexity: O(1)
#         """
#         if self.stack:
#             return self.stack[-1][1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
