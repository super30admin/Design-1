
# Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.arr = []
        
# Time Complexity : O(1)
    def push(self, val: int) -> None:
        self.arr.insert(0,val) # appending an item to the array will perform the push operation 
                
# Time Complexity : O(1)
    def pop(self) -> None:
        self.arr =self.arr[1:] # The array is updated such that index 1 ---> new index zero
        
# Time Complexity : O(1)

    def top(self) -> int:
        return self.arr[0]
# Time Complexity : O(n)

    def getMin(self) -> int:
        
        return min(self.arr)

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
