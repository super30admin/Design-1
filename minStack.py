#Time Complexity : O(1) - push, pop, top, getMi
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class MinStack:

    def __init__(self):
        '''Initialize the empty stack and min value with max integer value'''
        self.min = 2 ** 31
        self.stack = []
        #self.stack.append(self.min)

    def push(self, val: int) -> None:
        '''compare the prev min to the val and push both val and
        min to stack if the min. is updated, else only push val
        '''
        if val <= self.min:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)

    def pop(self) -> None:
        popped = self.stack.pop()
        '''compare the popped val with the min, if they are equal
        then pop twice from the stack and update the min with last popped val
        '''
        if popped == self.min:
            self.min = self.stack.pop()

    def top(self) -> int:
        '''returns the top/last element of the stack '''
        return self.stack[-1]

    def getMin(self) -> int:
        '''returns the min value which represents the min element in the stack'''
        return self.min

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()