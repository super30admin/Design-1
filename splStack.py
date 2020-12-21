#Time complexity = O(1)
#Code ran on leetcode with Runtime error
class MinStack:

    def __init__(self):
        self.stack = []

#rtype : None
    def push(self, x):
        self.stack.append(x)

#rtype : None
    def pop(self):
        self.stack.pop()


#rtype : int
    def top(self):
        return self.stack.pop(len(self.stack)-1)


#rtype : int
    def getMin(self):
        return min(self.stack)



# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(5)
obj.push(-1)
obj.push(0)
obj.push(-2)
obj.push(7)
obj.push(10)
obj.pop()
param_3 = obj.top()
print("Item at the top of the stack {}".format(param_3))
param_4 = obj.getMin()
print("Minimum item in the stack {}".format(param_4))
