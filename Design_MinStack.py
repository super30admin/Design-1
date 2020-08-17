# Time Complexity : O(n)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        # two stacks to maintain all values and current minimum value with counter for avoiding removing min value from min stack which occurs multiple times in all value stack
        # so even if min value is removed once we decrease the counter but if it still exists in the min stack then get min will still return this value
        self.stack=[]
        self.minStack=[]
        

    def push(self, x: int) -> None:
        # push to all value stack for any case
        self.stack.append(x)
        # if min stack is empty or the current top of minStack is less than current element then append to min stack current value and couter as 1
        if not self.minStack or x<self.minStack[-1][0]:
            self.minStack.append([x,1])
        # if min stack topmost element same as current element then increment the counter
        elif x==self.minStack[-1][0]:
            self.minStack[-1][1]+=1
        

    def pop(self) -> None:
        # if top element of all values stack is same as min stack then decrease the counter
        if self.stack[-1]==self.minStack[-1][0]:
            self.minStack[-1][1]-=1
        # if last element of min stack couter becomes zero pop it
        if self.minStack[-1][1]==0:
            self.minStack.pop()
        # pop the topmost element from all values stack in any case
        self.stack.pop()
        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        if self.minStack:
            return self.minStack[-1][0]
        else:
            return 0
