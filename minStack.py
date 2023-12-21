""" Explanation: The push function takes an integer val as input and pushes it onto the stack. If the stack is empty, it sets the minimum
    value encountered as val and pushes the pair {val, val} onto the stack. If the stack is not empty, it calculates the new minimum value
    by taking the minimum of the current minimum value (st.top().second) and val, and pushes the pair {val, min_val} onto the stack, 
    where mn is the new minimum value.
    Pop removes the top element
    top returns the top element is the stack is not empty
    Time complexcity : O(1)
    Space complexcity : O(n)
"""



class MinStack(object):
    
    def __init__(self):
        self.stack = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if not self.stack:
            self.stack.append((val,val))
        else:
            min_val = min(self.stack[-1][1],val)
            self.stack.append((val,min_val))
        

    def pop(self):
        """
        :rtype: None
        """
        if self.stack:
            self.stack.pop()

    def top(self):
        """
        :rtype: int
        """
        if self.stack:
            return self.stack[-1][0]
        return 0

    def getMin(self):
        """
        :rtype: int
        """
        if self.stack:
            return self.stack[-1][1]
        return 0
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()