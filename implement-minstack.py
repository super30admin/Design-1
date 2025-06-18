'''
1) push()
Time complexity: O(1)
Space complexity: O(1)

2) pop()
Time complexity: O(1)
Space complexity: O(1)

3) top()
Time complexity: O(1)
Space complexity: O(1)

4) getMin()
Time complexity: O(1)
Space complexity: O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
'''
class MinStack:

    def __init__(self):
        self.minStack = []
        self.minValue = float('inf')
    '''
    Since I'm maintaining a single stack, everytime I push, compare if the value being pushed is <= min
    If yes then push prev min and current val and update min
    '''
    def push(self, val: int) -> None:
        if val<=self.minValue:
            self.minStack.append(self.minValue)
            self.minValue = min(self.minValue,val)
            self.minStack.append(val)
        else:
            self.minStack.append(val)
    '''
    Pop the top most element and if it's == min then pop the next element and update min
    '''
    def pop(self) -> None:
            popped = self.minStack.pop()
            if popped == self.minValue:
                self.minValue = self.minStack.pop()
    '''
    Returns the elemenet at the top of the stack
    '''
    def top(self) -> int: 
        if len(self.minStack) > 0:
            return self.minStack[-1]
    '''
    returns the min val
    '''
    def getMin(self) -> int:
        return self.minValue
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()