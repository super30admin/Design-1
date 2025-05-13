class MinStack:

    #Time complexity - o(1)
    #Space Complexity - o(n)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : Yes. Keeping a track of the duplicates but it was resolved with adding duplicates to the self.min array.

    def __init__(self):
        self.stack = []
        self.min = [None]
        

    def push(self, val: int) -> None:
        if self.min[-1] is None:
            self.min.append(val)
        elif self.min[-1]>=val:
            self.min.append(val)
        self.stack.append(val)

    def pop(self) -> None:
        if self.top()==self.min[-1]:
            self.min.pop()

        if len(self.stack)>0:
            self.stack.pop()
        

    def top(self) -> int:
        if len(self.stack)>0:
            return self.stack[-1]
        return -1
        

    def getMin(self) -> int:
        return self.min[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()