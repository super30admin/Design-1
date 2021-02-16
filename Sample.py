# Time Complexity : O(1), O(1), O(1), O(1)
# Space Complexity : worst case O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach
class MinStack(object):

    def __init__(self):
        self.stack = []
        self.min = sys.maxint

    def push(self, x):
        if x <= self.min:
            self.stack.append(self.min)
            self.min = x
        self.stack.append(x)

    def pop(self):
        popped = self.stack.pop()
        if popped == self.min:
            self.min = self.stack.pop()

    def top(self):
        return (self.stack[-1])

    def getMin(self):
        return (self.min)
        

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()