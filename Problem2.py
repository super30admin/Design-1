// Time Complexity : O(1) ?
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// 1. Use 2 stacks. One for keeping track of elements and other 
// for keeping track of minimum element at a given time
// 2. Keep track of mimimum element by push it to min stack.
// 3. When poping an element from minstack check if the value is minimum value. 
//    if yes, pop from both stacks.



class MinStack:

    def __init__(self):
        
        self.L=[]
        self.ms=[]
        
    def push(self, val: int) -> None:
        self.L.append(val)
        if not self.ms or val<= self.ms[-1]:
            self.ms.append(val)

    def pop(self) -> None:
        if self.L[-1] == self.ms[-1]:
                self.ms.pop()
        return self.L.pop()  

    def top(self) -> int:
        return self.L[-1]

    def getMin(self) -> int:
        return self.ms[-1]
     

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()


