# https://leetcode.com/problems/min-stack/description/
# Time Complexity O(1)
# Space Complexity O(1)
class MinStack:
    def __init__(self):
        self.st = []
        self.minst = []
        self.min = float("inf")
        self.minst.append(self.min)

    def push(self, x):
        self.min = min(x, self.min)
        self.minst.append(self.min)
        self.st.append(x)

    # Pop the top element
    def pop(self):
        self.st.pop()
        self.minst.pop()
        self.min = self.minst[-1]

    # Return top element
    def top(self):
        return self.st[-1]

    # Get the minimum element
    def getMin(self):
        return self.min
