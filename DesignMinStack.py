#Time Complexity : O(1) for all the operation that is push, pop, top and getMin
#Space Complexity : O(N) where N is the number of elements added to the stack
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class MinStack:

    def __init__(self):
        self.st = []
        self.min = float('inf')

    def push(self, val: int) -> None:
        if self.min >=  val:
            self.st.append(self.min)
            self.min = val
        self.st.append(val)

    def pop(self) -> None:
        if self.st.pop() == self.min:
            self.min = self.st.pop()

    def top(self) -> int:
        return self.st[-1]
        
    def getMin(self) -> int:
        return self.min