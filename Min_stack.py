#Time Complexity :O(1)
#Space Complexity :O(n)-> main stack
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : took some time to handle the empty min stack edge case. 
#I was storing 0 instead of the maximum integer value (infinity). 


#maintain Minimum till each position
# Update current minimum and store it for this stack position
# If stack became empty, reset minimum for next push


class MinStack:

    def __init__(self):
        self.st = []       # Main stack for all values
        self.ms = []       # Minimum till each position
        self.minV = float("inf")

    def push(self, value: int) -> None:
        # Update current minimum and store it for this stack position
        self.minV = min(value, self.minV)
        self.st.append(value)
        self.ms.append(self.minV)

    def pop(self) -> None:
        self.st.pop()
        self.ms.pop()

        # If stack became empty, reset minimum for next push
        self.minV = self.ms[-1] if self.ms else float("inf")

    def top(self) -> int:
        return self.st[-1]

    def getMin(self) -> int:
        return self.minV