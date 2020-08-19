// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack=[]


    def push(self, x: int) -> None: # using a stack but also adding two objects- list 
        if len(self.stack) == 0:    # while pushing to keep track of latest minimum
            self.stack.append([x,x])
            return
        minim=self.stack[-1][1]
        self.stack.append([x,min(x,minim)])


    def pop(self) -> None: #popping the element
             self.stack.pop()


    def top(self) -> int: # peeking the top element

            return self.stack[-1][0]

    def getMin(self) -> int: # getting minimum from maintained list of the push stack
            return self.stack[-1][1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()