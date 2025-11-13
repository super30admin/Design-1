# Time Complexity: O(1)
# Space Complexity: O(2n)
# Did this code successfully run on LeetCode: Yes
# Any problem you faced while coding this: I had some issues with the syntax; other than that, I am good

# Your code here along with comments explaining your approach:
#initialized two stacks one for tracking the actual value and one for minimum value
#updated the min in in push and pop because whenever a number comes or goes the min changes


class MinStack:

    def __init__(self):
        self.st = []
        self.minSt = []
        self.minimum = float("inf")
        self.minSt.append(self.minimum)
        

    def push(self, val: int) -> None:
        self.st.append(val)
        self.minimum = min(self.minimum,val)
        self.minSt.append(self.minimum)
        

    def pop(self) -> None:
        self.st.pop()
        self.minSt.pop()
        self.minimum = self.minSt[-1]
        

    def top(self) -> int:
        return self.st[-1]
        

    def getMin(self) -> int:
        return self.minimum
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()