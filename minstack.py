// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : No

class MinStack(object):
    
    # Need deep look!
    # Time and Space is O(1) and O(n)

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if not self.stack:
            self.stack.append((x,x))
            return 
        
        current_min = self.stack[-1][1]
        self.stack.append((x, min(x,current_min)))
        
        

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
