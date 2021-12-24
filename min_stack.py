
# avg time complexity O(1) worst O(n)
# avg space complexity O(n)

class MinStack:

    def __init__(self):
        self.arr = []
        self.min_val = sys.maxsize

    def push(self, val: int) -> None:
        if val <= self.min_val :
            self.arr.append(self.min_val)
            self.min_val = val
            
        self.arr.append(val)    


    def pop(self) -> None:
        if self.min_val == self.arr.pop():
            self.min_val = self.arr.pop()  

    def top(self) -> int:
        return self.arr[-1]
        
    def getMin(self) -> int:
        #return min(self.arr)
        return self.min_val


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()