'''
1. Used a list to implement the minstack and a class variable to store the min value initialized to maxsize 
2. For push operation, first check if the val is less than min val. If yes, push min first. Update minimum var to value. Then push the value
3. For pop, it is opposite to push. Check if popped value is the min value. If yes then pop again and restore the prev min value

Time Complexity : O(1)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

'''
import sys

class MinStack:

    def __init__(self):
        self.minstack =[]
        self.min = sys.maxsize

    def push(self, val: int) -> None:
        if val<=self.min:
            self.minstack.append(self.min)
            self.min = val
        self.minstack.append(val)

    def pop(self) -> None:
        if self.minstack.pop()==self.min: #popping value
            self.min = self.minstack.pop() #restoring the prev min 

    def top(self) -> int:
        return self.minstack[-1]
        
    def getMin(self) -> int:
        return self.min
        