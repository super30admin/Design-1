// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.mainstack = []
        self.minstack = []
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if len(self.mainstack) == 0:
            self.mainstack.append(x)
            self.minstack.append(x)
        else:    
            self.mainstack.append(x)
            if self.mainstack[-1] <= self.minstack[-1]:
                self.minstack.append(x)
        

    def pop(self):
        """
        :rtype: None
        """
        if len(self.mainstack)!=0:
            popped = self.mainstack.pop()
            if popped == self.minstack[-1]:
                self.minstack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return self.mainstack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.minstack[-1]
        
        
# Your MinStack object will be instantiated and called as such:
obj = MinStack()
# obj.push(x)
# # obj.pop()
# # param_3 = obj.top()
# # param_4 = obj.getMin()
print(obj.push(-2),obj.push(0),obj.push(-3),obj.getMin(),obj.pop(),obj.top(),obj.getMin())