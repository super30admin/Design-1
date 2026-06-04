#Time Complexity : The time complexity is O(1) for all the operations 
#Space Complexity : The space complexity is O(N) where N is no of elements pushed in stack
#Did this code successfully run on Leetcode : YES

class MinStack(object):

    def __init__(self):
        self.st=[]
        self.min=float('inf')

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if val <= self.min:
            self.st.append(self.min)
            self.min = val
            
        self.st.append(val)
        
    def pop(self):
        """
        :rtype: None
        """
        if not self.st:
            return
        if self.st.pop() == self.min:
            self.min = self.st.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return self.st[-1] if self.st else None
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()