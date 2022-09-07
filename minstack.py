#time complexity: O(1) for push -> because we are just appending the value after comparison, pop, top and getmin
#space complexity: O(2n) we are maintaining 2 spaces for each element
#passed all cases on LeetCode: yes
#difficulty faced: writing the comparison function for pushing minstack
# comments: watchout for the else condition of 1st if condition in case of push
#https://leetcode.com/problems/min-stack/

class MinStack:

    def __init__(self):
        self.stack = []
        self.minstack = []
        
        
    def push(self, val: int) -> None:
        
        if self.minstack:
            if(val < self.minstack[-1]):
                self.minstack.append(val)
            else:
                self.minstack.append(self.minstack[-1])
        else: #this else is needed to create the minstack initially
            self.minstack.append(val)
            
        self.stack.append(val)
        

    def pop(self) -> None:
        if self.stack and self.minstack:
            self.stack.pop()
            self.minstack.pop()

    def top(self) -> int:
        return self.stack[-1] if self.stack else None

    def getMin(self) -> int:
        return self.minstack[-1] if self.minstack else None       
