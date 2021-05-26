# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Y
# Any problem you faced while coding this : N


# Your code here along with comments explaining your approach

## Store min val in the current list along with current value as a tuple

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.list = []

    def push(self, val: int) -> None:
        if len(self.list) == 0:
            self.list.append((val, val))
        else:
            if self.list[-1][1] <= val:
                self.list.append((val, self.list[-1][1]))
            else:
                self.list.append((val, val))

    def pop(self) -> None:
        return self.list.pop()[0]

    def top(self) -> int:
        return self.list[-1][0]

    def getMin(self) -> int:
        return self.list[-1][1]


if __name__ == '__main__':

    obj = MinStack()
    obj.push(-2)
    obj.push(0)
    obj.push(-3)
    print("push(2,0,-3)")
    print("min", obj.getMin())
    print("pop", obj.pop())
    print("top", obj.top())
    print("min", obj.getMin())

    print(obj.list)