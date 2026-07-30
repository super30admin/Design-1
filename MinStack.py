# Time Complexity: O(1) for push, pop, top, and getMin
# Space Complexity: O(n)

# Did this code successfully run on LeetCode: Yes

class MinStack(object):

    def __init__(self):
        self.st, self.minSt = [], []
        self.min = float("inf") 
        

    def push(self, value):
        """
        :type value: int
        :rtype: None
        """
        if value <= self.min:
            self.minSt.append(self.min)
            self.min = value
        self.st.append(value)
        
        

    def pop(self):
        """
        :rtype: None
        """
        if self.min == self.st.pop():
            self.min = self.minSt.pop()
        

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
obj = MinStack()
obj.push(2)
obj.push(1)
obj.push(4)
obj.pop()
print(obj.top())
print(obj.getMin())