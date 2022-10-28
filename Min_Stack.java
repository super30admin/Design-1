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
	# initialise two list one is main where all value is added second is min where min value is added 
        self.main = []      
        self.min = []
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
	# all value is puch to main list while value is added to min list if list is empty or current value is less
        self.main.append(x)
        if len(self.min) == 0 or x <= self.min[-1]:
            self.min.append(x)

    def pop(self):
        """
        :rtype: None
        """
	# from Main list values are poped but from min list value is only poped if the value poped from main is minimum value
        k = self.main.pop()
        if k == self.min[-1]:
            self.min.pop()

    def top(self):
        """
        :rtype: int
        """
	# return the right most value from main list which is the top value
        return self.main[-1]

    def getMin(self):
        """
        :rtype: int
        """
	# return the right most value from min list which is minimum value
        return self.min[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()