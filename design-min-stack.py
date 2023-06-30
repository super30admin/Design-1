'''
// Time Complexity : 
    Push Avg : O(1) Worst : amortized O(N)
    pop  Avg, Best , Worst : O(1)
// Space Complexity : O(N) N - number of elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No


// Your code here along with comments explaining your approach
'''

'''
    - Stack is implemented through python list, every element is stored with min of stack
    Eg:
        1,1
        5,2
        2,2
        4,4
        
    - Push : during push add min by calling getMin()
    - Pop : pop both element and min as of that element
    
'''
class MinStack:

    def __init__(self):
        self.stack=[]

    def push(self, val: int) -> None:
        if not self.stack:
            self.stack.append((val,val))
        else:
            self.stack.append((val,min(self.getMin(),val)))
        

    def pop(self) -> None:
        self.stack.pop()
        

    def top(self) -> int:
        if self.stack:
            return self.stack[-1][0]
        else:
            return None

    
    def getMin(self) -> int:
        if self.stack:
            return self.stack[-1][1]
        else:
            return None
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(4)
# obj.push(5)
# obj.push(6)
# obj.pop() -> 6
# param_3 = obj.top()
# param_4 = obj.getMin()