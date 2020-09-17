// Time Complexity : O(1)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class MinStack:
#S30
    def __init__(self): 
        """
        initialize your data structure here.
        """
        self.arr = []
        self.min = 9999

        

    def push(self, x: int) -> None:
        if not self.arr:
            self.min = x
            
        if x <= self.min:
            self.arr.append(self.min)
            self.min = x
            
        self.arr.append(x)
        #print(self.arr)
        

    def pop(self) -> None:
        
        if self.arr.pop() == self.min :
            self.min = self.arr.pop()
        #print(self.arr)
        
        

    def top(self) -> int:
        return self.arr[-1]
        

    def getMin(self) -> int:
        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()