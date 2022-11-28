# // Time Complexity :O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No 



# // Your code here along with comments explaining your approach


class minStack:
    def __init__(self):
        # we will be using just 1 stack
        self.Stack = []
        self.min = float("inf")
        # self.Stack.append(self.min)

    def push(self, val):
        if self.min >= val:
            self.Stack.append(self.min)
            self.min = val
        self.Stack.append(val)
    
    def pop(self):
        poppedElement = self.Stack.pop()
        if self.min == poppedElement:
            self.min = poppedElement
    
    def top(self):
        return self.Stack[-1]
    
    def getMin(self):
        return self.min


# testing the minStack

minStackInstance = minStack()

print(minStackInstance.push(4))
print(minStackInstance.push(5))
print(minStackInstance.push(1))
print(minStackInstance.push(9))
print(minStackInstance.getMin())
print(minStackInstance.top())
print(minStackInstance.pop())
print(minStackInstance.getMin())
print(minStackInstance.pop())
print(minStackInstance.getMin())