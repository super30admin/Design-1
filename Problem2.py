
#Time complexity: 
# Push, Pop, Top, getMin - O(1)

#Space complexity:
# Push, Pop, Top, getMin - O(1)

#Approach
#On pushing compare previous min value with current value and set minVal for current node accordingly - which is the global minVal when that node is on top

#Accepted on Leetcode

#Problems
# Had to use a hint on Leetcode
# Realized was using the 'Run Code' on Leetcode to test instead of framing test cases by myself, must test thoroughly such that execution successful on first run



class MinStackNode:
    def __init__(self, val, minVal):
        self.val = val
        self.min = minVal

class MinStack:

    def __init__(self):
        self.stack = []
        

    def push(self, val: int) -> None:
        curMinVal = self.stack[-1].min if len(self.stack) else float('inf')
        newMinVal = val if val < curMinVal else curMinVal
        
        newNode = MinStackNode(val, newMinVal)
        self.stack.append(newNode)
        

    def pop(self) -> None:
        self.stack.pop()
        

    def top(self) -> int:
        return self.stack[-1].val
        

    def getMin(self) -> int:
        return self.stack[-1].min
        

