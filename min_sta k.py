
#  Time Complexity

O(1)

#  Space complexity 

O(2N) = O(N)

# yes cod ran succesfully on leetcode







class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.st = []
        self.min_st= []
        self.min = float('inf')
        self.min_st.append(min)

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
    
        self.min = min(self.min,val)
        self.st.append(val)
        self.min_st.append(self.min)

    def pop(self):
        """
        :rtype: None
        """
        self.st.pop()
        self.min_st.pop()
        self.min = self.min_st[-1]
        
        

    def top(self):
        """
        :rtype: int
        """
        return self.st[-1]

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
