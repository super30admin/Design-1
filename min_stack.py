# Q. Design minstack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MinStack(object):

    def __init__(self):
        self.primaryStack = []
        self.minStack = []

    def push(self, val):  # TC: O(1), SC: O(1)
        """
        :type val: int
        :rtype: None
        """
        # if minStack is empty, append +infinity as the bottommost element
        if (len(self.minStack) == 0):
            self.minStack.append(float('inf'))

        # append to primaryStack, find min value and append that to minStack
        self.primaryStack.append(val)
        self.minStack.append(min(self.getMin(), val))
        return

    def pop(self):  # TC: O(1), SC: O(1)
        """
        :rtype: None
        """
        # pop from primaryStack & minStack
        self.primaryStack.pop()
        self.minStack.pop()
        return

    def top(self):  # TC: O(1), SC: O(1)
        """
        :rtype: int
        """
        # if primaryStack is not empty, return top of stack(last element)
        if len(self.primaryStack) != 0:
            return self.primaryStack[-1]
        return None

    def getMin(self):  # TC: O(1), SC: O(1)
        """
        :rtype: int
        """
        # if minStack is not empty, return top of stack(last element)
        if len(self.minStack) != 0:
            return self.minStack[-1]
        return None


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# print(obj.push(2147483646))
# print(obj.push(2147483646))
# print(obj.push(2147483647))
# print(obj.top())
# print(obj.pop())
# print(obj.getMin())
# print(obj.pop())
# print(obj.getMin())
# print(obj.pop())
# print(obj.push(2147483647))
# print(obj.top())
# print(obj.getMin())
# print(obj.push(-2147483648))
# print(obj.top())
# print(obj.getMin())
# print(obj.pop())
# print(obj.getMin())


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(3)
# obj.push(3)
# obj.pop()
# param_3 = obj.top()
# print(param_3)
# param_4 = obj.getMin()
# print(param_4)
