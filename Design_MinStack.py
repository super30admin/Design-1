# Time Complexity : O(1), getMin is also O(1) since we store min value at the topmost index
# Space Complexity : O(n), n pushed elements 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No, it was easier than HashMap implementation. I did not understand by 'isFull' method, Do we set the size of the array?

# Code: 
# Will store min value of the stack along with each appended value, easy to retrieve!
class MinStack:
    def __init__(self):
        self.s =[]

    # checks if any element is present
    def isEmpty(self): 
        if not self.s:
            return True
        return False 
    
    def push(self, x: int):       
        # If it is the first value, current value itself is the min value at the moment
        if not self.s:
            # store Value, min value
            self.s.append((x, x))
            return
        # retrieve min value from top of the stack
        current_min = self.s[-1][1] 
        # append value and minimum of (current value, previously established min value) 
        self.s.append((x, min(x, current_min)))
        
    def pop(self):
        # array pop operation is similar to stack pop
        self.s.pop()
        
    def top(self):
        # stack is LIFO
        # last element is the topmost
        return self.s[-1][0]

    def getMin(self):
        # last element contains the latest min value
        return self.s[-1][1]

minStack = MinStack()
print(minStack.isEmpty())
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
min1 = minStack.getMin(); # return -3
minStack.pop();
min2 = minStack.top();    # return 0
min3 = minStack.getMin(); # return -2
print(minStack.s)
print(min1, min2, min3)
print(minStack.isEmpty())
