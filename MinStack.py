# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes!
# Any problem you faced while coding this : Not really

# Your code here along with comments explaining your approach
class MinStack(object):

    def __init__(self):
        # adding and removing every time from this stack.
        self.stack = []
        # adding and removing only when a new min is introduced.
        self.min_stack = []

    def push(self, x):
        # if first element or x less than current min, append to min_stack
        if len(self.min_stack) == 0 or x <= self.min_stack[len(self.min_stack)-1]:
            self.min_stack.append(x)
        # append to normal stack
        self.stack.append(x)


    def pop(self):
        # if element being removed is current min, pip min_stack
        if self.stack[len(self.stack)-1] == self.min_stack[len(self.min_stack)-1]:
            self.min_stack.pop()
        # pop from normal stack
        self.stack.pop()

    def top(self):
        # if stack not empty, return last inserted element
        if len(self.stack) > 0:
            return self.stack[len(self.stack)-1]
        # else return -1
        return -1

    def getMin(self):
        # if min_stack not empty, return current min
        if len(self.min_stack) > 0:
            return self.min_stack[len(self.min_stack)-1]
        # else return -1
        return -1

    def isEmpty(self):
        return len(self.stack) == 0

# Your MinStack object will be instantiated and called as such:
minStack = MinStack()
print minStack.getMin()

minStack.push(2147483646)
minStack.push(2147483646)
minStack.push(2147483647)
print "top", minStack.top(), "should return", 2147483647
print "pop", minStack.pop(), "should return", None
print "min", minStack.getMin(), "should return", 2147483646

print "pop", minStack.pop(), "should return", None
print "min", minStack.getMin(), "should return", 2147483646
print "pop", minStack.pop(), "should return", None

minStack.push(2147483647)
print "top", minStack.top(), "should return", 2147483647
print "min", minStack.getMin(), "should return", 2147483647

minStack.push(-2147483648)
print "top", minStack.top(), "should return", -2147483648
print "min", minStack.getMin(), "should return", -2147483648
print "pop", minStack.pop(), "should return", None
print "min", minStack.getMin(), "should return", 2147483647

