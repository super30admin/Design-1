#// Time Complexity : O(1)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : had few syntax doubts but was clear on the code flow.


class MinStack:

    def __init__(self):
        self.st = []  # primary stack
        self.minSt = []  # MinValue maintaining stack 

    def push(self, val: int) -> None:
        self.st.append(val)
        # append either the smallest value in self.mins
        # val (if empty, add val)
        if len(self.minSt) == 0:
            self.minSt.append(val)
        else:
            prev_min = self.minSt[len(self.minSt)-1]
            if prev_min>val:
                self.minSt.append(val)
            else:
                self.minSt.append(prev_min)
            
        
    def pop(self) -> None:
        self.st.pop(len(self.st)-1)
        self.minSt.pop(len(self.minSt)-1)

    def top(self) -> int:
        return self.st[len(self.st)-1]
    
    def getMin(self) -> int:
        return self.minSt.pop(len(self.minSt)-1)