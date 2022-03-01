# Time Complexity O(1) for all operation except the finding minimum
# Space Complexity O(n) overall
# Issues -> Getting the minimum value in O(1) time frame

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.arr = []

    def push( self, val: int) -> None:
        self.arr.append(val)

    def pop(self) -> None:
        
        self.arr.pop(-1)

    def top(self) -> int:
        return self.arr[-1]        

    def getMin(self) -> int:
        return min(self.arr)


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
