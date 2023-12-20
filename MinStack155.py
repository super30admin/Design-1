# Time Complexity :
# push: O(1) as Array#append is O(1) amotized
# top: O(1) since we store data in an array
# pop: O(1) since we pop from the end of an array
# getMin: O(1) since we lookup using index (the last element)
# Space Complexity :
# O(1) for all operations
class MinStack:

    def __init__(self):
        self.stack = []

    def push(self, val: int) -> None:
        self.stack.append((val, min(val, self.getMin())))

    def pop(self) -> None:
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        if len(self.stack) == 0:
            return math.inf

        return self.stack[-1][1
