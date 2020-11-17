# Time Complexity :  O(1) for all
# Space Complexity : O(N) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

class MinStack(object):
    
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
        self.stack.append((x,min(x,self.stack[-1][1])))
        

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


'''
1st approch : maintaining stack and sorted array / but it takes log(n) time for push
2nd approch : stack with two values minvalue and append value
'''