from collections import deque
import sys

# Time Complexity : O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Not anything particular

class MinStack:

    def __init__(self):
        #Here we are implementing the double ended queue, As we know we can implement stack from the double ended queue, We can also implement stack with list
        self.primarys=deque()
        self.min=sys.maxsize 
        #print(self.primarys)
        
    def push(self, val: int) -> None:
        #Here Idea is very simple when ever the minimum is changed insert the minumum,insert key otherwise only insert the key only
        if(val<=self.min):
            self.primarys.append(self.min)
            self.primarys.append(val)
            self.min=val
        else:
            self.primarys.append(val)
        #print(self.primarys)

    def pop(self) -> None:
        #Here we are doing the opposite to the push
        
        if(self.primarys[-1]>self.min):
            self.primarys.pop()
        else:
            self.primarys.pop()
            #Changing the minimum to the previous minimum
            self.min=self.primarys[-1]
            self.primarys.pop()
        
        
        

    def top(self) -> int:
        #Here if we want we can also add the edge case
        return self.primarys[-1]

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()