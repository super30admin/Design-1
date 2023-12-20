# // Time Complexity : O(1)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : Had to think about how to manage getMin properly.


# // Your code here along with comments explaining your approach

# We maintain two arrays - arrays and minVal.

class MinStack:

    def __init__(self):
        self.array = []
        self.minVal = []
    # When pushing, we have to append to the top of the array as well as put the minimum value in the minVal. 
    def push(self, val: int) -> None:
        self.array.append(val)
        if len(self.minVal) == 0:
            self.minVal.append(val)
        else:
            if val < self.minVal[-1]:
                self.minVal.append(val)
            else:
                self.minVal.append(self.minVal[-1])
        

    def pop(self) -> None:
        self.array.pop()
        self.minVal.pop()
        

    def top(self) -> int:
        return self.array[-1]

    def getMin(self) -> int:
        return self.minVal[-1]