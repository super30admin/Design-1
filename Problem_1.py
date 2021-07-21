'''Min Stack'''
# Time Complexity : O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
class MinStack:
    def __init__(self):
        '''
        Maintain stack and a min element
        As we encounter a smaller element, we push previous min and update current min
        '''
        self.stack = []
        self.cur_min = float('inf')

    def push(self, val: int) -> None:
        '''
        If current element smaller than min, push min and current element on stack
        Else push just current element
        '''
        if val <= self.cur_min :
            self.stack.append(self.cur_min)
            self.cur_min = val
        self.stack.append(val)

    def pop(self) -> None:
        '''
        If current min is being popped, update min as next element from the stack
        '''
        popped = self.stack.pop() 
        if popped == self.cur_min:
            self.cur_min = self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.cur_min
    
# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()