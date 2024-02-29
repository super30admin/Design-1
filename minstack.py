# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Faced issues while implementing in Python. mainly scope issues related to minimum variable


# // Your code here along with comments explaining your approach
# I used the Two Stacks approach. I initialized two stacks, one normal and one for minimum values. The normal stack had the normal values, while the minimum stack consists of minimum value.
# It checks the value with the minimum value everytime as the new value is pushed to the stack. And updates the minstack accordingly.

class MinStack:
    def __init__(self):
        self.st = []
        self.minSt = [float('inf')]   

    def push(self, val: int) -> None:
        minimum = min(val, self.minSt[-1])
        self.minSt.append(minimum)
        self.st.append(val)

    def pop(self) -> None:
        self.st.pop()
        self.minSt.pop()

    def top(self) -> int:
        return self.st[-1]

    def getMin(self) -> int:
        return self.minSt[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
