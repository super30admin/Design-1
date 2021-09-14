

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.arr = []
        

    def push(self, val: int) -> None:
        self.arr.insert(0,val) # appending an item to the array will perform the push operation 
                

    def pop(self) -> None:
        self.arr =self.arr[1:] # The array is updated such that index 1 ---> new index zero
        

    def top(self) -> int:
        return self.arr[0]

    def getMin(self) -> int:
        
        return min(self.arr)

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
