#Time Complexity: O(1) for all the methods
# Space Complexity: O(2n) -> O(n)
# Did this code successfully run on Leetcode: Yes


# Your code here along with comments explaining your approach


class MinStack(object):

    def __init__(self):
        self.stack = []
        

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        min_val = val
        
        # get the current minimum value in the stack and compare with current val that is getting pushed
        # if val is less than the current minimum, add this val as minium along with the val
        # otherwise old current minium remains unchanged
        if len(self.stack) > 0:
            current_min = self.stack[-1][1]
            if current_min < min_val:
                min_val = current_min

        self.stack.append((val, min_val))
        

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1][0]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.stack[-1][1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()