#Time Complexity : O(1) for all the operation that is push, pop, top and getMin
#Space Complexity : O(N) where N is the number of elements added to the stack
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

#Approach: We use array to implement stack. We check for minimum in every push and append it if the minimum changes along with the value. 
#When popping, if the popped element if equal to the minimum, we pop again.

class MinStack:

    def __init__(self):
        self.st = []
        self.min = float('inf')

    def push(self, val: int) -> None:
        if self.min >=  val:
            self.st.append(self.min)
            self.min = val
        self.st.append(val)

    def pop(self) -> None:
        if self.st.pop() == self.min:
            self.min = self.st.pop()

    def top(self) -> int:
        return self.st[-1]
        
    def getMin(self) -> int:
        return self.min