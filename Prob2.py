# Time Complexity : All opertions are O(1)
# Space Complexity : O(N) N is the number of elements.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
#   Used 2 stacks approach. 
#   Main stack to store elements, and Min stack to store the minimum value up to that point.
#   In pop fucntion, to take care of the last element edge case, we check if top of both stacks are the same, pop out from min stack too if it is equal else only from main stack.
#   In push fucntion, we push to min stack only if min stack is empty or if new value is less than or equal to top of min stack (min value so far).

class MinStack:

    def __init__(self):
        self.MinStack=[]
        self.MainStack=[]

    def push(self, val: int) -> None:
        if len(self.MinStack)==0 or (len(self.MinStack)>0 and val<=self.MinStack[-1]):
            self.MinStack.append(val)
        self.MainStack.append(val)

    def pop(self) -> None:
        if self.MinStack[-1]==self.MainStack[-1]: #pop out from minstack if current min (top of minstack) and top of Mainstack are equal
            self.MinStack.pop()
        self.MainStack.pop()

    def top(self) -> int:
        return self.MainStack[-1]

    def getMin(self) -> int:
        return self.MinStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()