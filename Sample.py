#space complexity is O(1)
# time complexity of push,pop,top are O(1) but getMin has O(n) 
class MinStack:

    def __init__(self):
        self.minStack = []
        

    def push(self, val: int) -> None:
        self.minStack += [val]
        

    def pop(self) -> None:
        self.minStack = self.minStack[:-1]
        

    def top(self) -> int:
        return self.minStack[-1]
        

    def getMin(self) -> int:
        minVal = 2**31-1
        for i in self.minStack:
            if i < minVal:
                minVal = i
        return minVal

        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()