'''
I created the minstack using a single stack and keeping track of the prev minimum and elements
in the same array.
Here the time complexity = O(1)
space complexity = O(n) (doubtful). Please correct me if I am wrong.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes  I was initializing the stack with the infinity. This
was giving many errors especially in the push function.  Also, I was only checking x<min whereas, it should
be x <= min. Also, there were irrelevant if else ladders which i used.
In the pop function, I was not checking condition popped == min before popping the
previous minimum.
'''


class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = sys.maxint

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if x <= self.min:
            self.stack.append(self.min)
            self.min = x

        self.stack.append(x)

    def pop(self):
        """
        :rtype: None
        """
        popped = self.stack.pop()
        if popped == self.min:
            self.min = self.stack.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.min

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()