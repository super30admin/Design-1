'''
We push the curr_min to the stack when new min element is pushed before pushing that min element. 
Accordingly, pop operation needs to handle removal process when curr_min is getting poped

# Time Complexity : 
    O(1) for push, pop, top, getMin
# Space Complexity :
    O(N) 
# Did this code successfully run on Leetcode :
    - yes
# Any problem you faced while coding this :
    - When an element equal to curr_min is pushed 
    def push(val):
        if val<=self.curr_min: (equal to sign)
            ...
            ...
        ...
'''


class MinStack:

    def __init__(self):
        self.st = []
        self.curr_min = 2**31 # Given: Values will be smaller than this

    def push(self, val: int) -> None:
        if val<=self.curr_min:
            self.st.append(self.curr_min)
            self.curr_min = val
        self.st.append(val) # [2**31,-2,0,-2,-3]

    def pop(self) -> None:
        last = self.st[-1]
        self.st.pop()
        if last==self.curr_min:
            self.curr_min = self.st[-1] #[2**31,-2,0,-2,-3] ->pop->[2**31,-2,0,-2] since -3 was minimum, we need to make one more pop and update min
            self.st.pop()
        

    def top(self) -> int:
        return self.st[-1]

    def getMin(self) -> int:
        return self.curr_min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()