
# Code Successfully ran on Leetcode, Please refer Readme.md for Runtime Analysis


class MinStack:
    def __init__(self):
        self.stack = []
        self.min = 0

    def push(self, val: int) -> None:
        """
        Push an element onto the stack
        While Pushing an element, check the previous minimum and push it onto stack
        :param val:
        :return: None
        """
        # Time Complexity : O(1)
        # Space Complexity : O(1)
        if not self.stack:
            self.stack.append(val)
            self.min = val
        else:
            if val <= self.min:
                self.stack.append(self.min)
                self.min = val
            self.stack.append(val)

    def pop(self) -> None:
        """
        Pop an element out of the stack

        :return: None
        """
        # Time Complexity : O(1)
        # Space Complexity : O(1)
        x = self.stack.pop()
        if self.stack and self.min == x:
            self.min = self.stack.pop()

    def top(self) -> int:
        """
        Get the top of the stack
        :return: Top of the Stack
        """
        # Time Complexity : O(1)
        # Space Complexity : O(1)
        return self.stack[-1]

    def getMin(self) -> int:
        """
        Get the Minimum Element of the Stack
        :return: Minimum Element of the Stack
        """
        # Time Complexity : O(1)
        # Space Complexity : O(1)
        return self.min


if __name__ == "__main__":
    obj = MinStack()
    obj.push(9)
    obj.push(1000)
    obj.push(7)
    print(obj.getMin())
    obj.pop()
    print(obj.getMin())
