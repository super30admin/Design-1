# Time Complexity : O(1) for all operations
# Space Complexity : O(n) -> n is no of elements in stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Store each value along with the minimum value seen so far at that point.


class MinStack:
    def __init__(self):
        self.st = []

    def push(self, val: int) -> None:
        curr_min = self.getMin()
        if curr_min == None or curr_min > val:
            curr_min = val
        self.st.append([val,curr_min])

    def pop(self) -> None:
        self.st.pop()

    def top(self) -> int:
        return self.st[-1][0]

    def getMin(self) -> int:
        return self.st[-1][1] if self.st else None


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()