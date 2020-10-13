
# In th min stack all the operations have to be O(1) tim. Therefore, as I used 2 arrays one to keep a track of all elements and othere to keep a track of minimum element.
# If the current element is less than last element in minimum element array, then append this current element to minimum element array.
# The minimum element will always be the last element in the array.
# Time Complexity : O(1) for all operations 
# Space Complexity : O(2n) for push and get minimum
# Any problem you faced while coding this : No 
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.arr = []
        self.minArr = []

    def push(self, x: int) -> None:
        if (len(self.minArr)==0):
            self.minArr.append(x)
        if (len(self.minArr)!=0):
            if (x < self.minArr[-1]):
                self.minArr.append(x)
            else:
                self.minArr.append(self.minArr[-1])
        self.arr.append(x)

    def pop(self) -> None:
        elem = self.arr[-1]
        del(self.arr[-1])
        return elem
        

    def top(self) -> int:
        elem = self.arr[-1]
        return elem
        

    def getMin(self) -> int:
        minElem = self.minArr[-1]
        return minElem
        

# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(2)
obj.push(1)
obj.push(4)
obj.push(5)
obj.pop()
param_3 = obj.top()
print("Top Element",param_3)
param_4 = obj.getMin()
print("Minimum Element in stack",param_4)
