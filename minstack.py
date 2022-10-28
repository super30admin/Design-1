
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach
//i pushed the element as well as minimum element so far occured in the stack.so at the end the top of stack will have a minimum element just return that eleemnt will be a constant time operation
class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack=[]

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """

        #so if the stack is empty then the first value itself will be minimum
        if not self.stack:
            self.stack.append([val,val])
            return 
        current_minimum = self.stack[-1][1]
        self.stack.append([val,min(val,current_minimum)])  //push value as well as the minimum so far
        

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()   

    def top(self):
        """
        :rtype: int
        """
        return self.stack[len(self.stack)-1][0]

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