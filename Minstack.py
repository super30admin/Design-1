'''
Time Complexity : O(1) 
Space Complexity : O(n), n is number of elements
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Your code here along with comments explaining your approach:
        pushing the value and minimum element till now in the stack as tuple.
        everytime when we push, we will check for the minimum value too.
        This will ensure only one comparison.
'''

class MinStack:

    def __init__(self):
        self.minstack = []

    def push(self, val: int) -> None:
        if len(self.minstack)==0:
            self.minstack.append((val, val))
        else:
            minele = self.minstack[-1][1]
            if minele < val:
                self.minstack.append((val, minele))
            else:
                self.minstack.append((val, val))

    def pop(self) -> None:
        self.minstack.pop()

    def top(self) -> int:
        if len(self.minstack)>0:
            return self.minstack[-1][0]
        
    def getMin(self) -> int:
        if len(self.minstack)>0:
            return self.minstack[-1][1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()