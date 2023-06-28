// Problem 2 : Min Stack

// Time Complexity : O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// I have used a single array for solving the problem. In each push operation, I am inserting 
// a combination of minimum value and the value pushed. The minimum value is maintained at every level.



class MinStack:

    def __init__(self):
        self.min_stack=[]
        

    def push(self, val: int) -> None:
        if len(self.min_stack) == 0:
            self.minimum = float("infinity")
        else:
            self.minimum = self.min_stack[-1][1]
        if val < self.minimum:
            self.minimum = val
            
        self.min_stack.append([val,self.minimum])

    def pop(self) -> None:
        self.min_stack.pop()

    def top(self) -> int:
        return self.min_stack[-1][0]

    def getMin(self) -> int:
        return self.min_stack[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()


