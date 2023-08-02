# Time Complexity : o(1)
# Space Complexity :o(n) -> n represents maximum number of elements present in either stack1 or stack2
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : None

"""
This program tries to retrive the minimum element from the stack, to acheive that, 2 stacks are used and the stack stores one to one mapping and keeps track of the minimum element in seperate variable.
minimum element is updated whenever there is change in minimum value
"""

class MinStack:

    def __init__(self):
        self.stack1= []
        self.stack2 = []
        self.stack1_size =0
        self.stack2_size = 1
        self.min = (2 ** 31)-1
        self.stack2.append(-1)

    """
    minimum value is updated when self.min> new value, append the value in stack1 and the minimum in stack2 simultaneoulsy and increase the size accordingly
    """
    def push(self, val: int) -> None:
        if self.min>=val:
            self.min = val
        self.stack1.append(val)
        self.stack2.append(self.min)
        self.stack1_size = self.stack1_size+1
        self.stack2_size = self.stack2_size + 1

    """
    while popping, keep track of minimum, whenever minimum is popped, next minimum in the stack is new minimum or else initialize the minimum to maximum integer when there r no elements
    """
    def pop(self) -> None:
        if self.stack1_size>=1:
            self.stack1.pop(self.stack1_size-1)
            self.stack1_size = self.stack1_size - 1
            minimum = self.stack2.pop(self.stack2_size-1)
            self.stack2_size = self.stack2_size - 1
            if minimum == self.min and self.stack2_size>1:
                minimum = self.stack2[self.stack2_size-1]
                self.min = minimum
            else:
                self.min = 2**31 -1

    """Top of the stack always refers to the element at the maximum size"""

    def top(self) -> int:
        if self.stack1_size>=1:
            return self.stack1[self.stack1_size-1]

    """minimum value is retrived from stack2 which is considered to be minstack"""
    def getMin(self) -> int:
        if self.stack2_size>=1:
            return self.stack2[self.stack2_size-1]
        else:
            return 0

#
# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(2147483646)
obj.push(2147483646)
obj.push(2147483647)

param_2= obj.top()
print(param_2)
obj.pop()
param_1 = obj.getMin()
print(param_1)

obj.pop()
param_1 = obj.getMin()
print(param_1)
obj.pop()

obj.push(2147483647)
param_2= obj.top()
print(param_2)
param_3 = obj.getMin()
print(param_3)

obj.push(-2147483648)
x=obj.top()
print(x)
param_3 = obj.getMin()
print(param_3)

obj.pop()
param_3 = obj.getMin()
print(param_3)