#Time Complexity : O(1) for all 4 functions
#Space Complexity : O(n) for push, O(1) for pop,top and getMin
#Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Your code here along with comments explaining your approach

class MinStack:

    def __init__(self):
        self.my_stack = []
        #Setting minimum value to infinity because if any first number pushed will be less than infinity and becomes min val
        self.min_val = float('inf')

    def push(self, val: int) -> None:
        # If pushed value less than infinity pushing the infinity into stack and updating min val to value
        if val <= self.min_val:
            self.my_stack.append(self.min_val)
            self.min_val = val
        # If pushed value is not less that min value we are only appending
        self.my_stack.append(val)

    def pop(self) -> None:
        #Popping once mandatory and if popped value is same as min value we will pop again and update the min val to 2nd popped value
        if self.my_stack.pop() == self.min_val:
            self.min_val = self.my_stack.pop()
    # returning the last inserted element
    def top(self) -> int:
        return self.my_stack[-1]
    #Getting the min available value in the stack
    def getMin(self) -> int:
        return self.min_val

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()