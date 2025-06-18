# Time Complexity - O(1)
# Space Complexity - O(n) depends on the number of elements pushed 
# Did the code run on leetcode - yes
# Problems faced and approach - I have initialised two arrays stack and minStack, minStack is used to manage
# the minimum element till then. In push, I have added the element in stack and in minStack, I have compared 
# it with the previous element in minStack. And then add accordingly, in pop I reduced the count first, to refer 
# to the latest element. And then remove it, and re-initiliazie the same index in both the stacks. Top and geMin were
# fairly simple, just returninf the element at the latest index. 

class MinStack:

    def __init__(self):
        self.stack = [0] * 10000 
        self.count = 0
        self.minStack = [0] * 10000
        
    def push(self, val: int) -> None:
        self.stack[self.count] = val
        if self.count == 0:
            self.minStack[self.count] = val
        else:
            if self.minStack[self.count - 1] < val:
                self.minStack[self.count] = self.minStack[self.count - 1]
            else:
                self.minStack[self.count] = val
        self.count += 1
        
    def pop(self) -> None:
        self.count -= 1
        popped = self.stack[self.count]  # made a mistake here, was checking count which is the next element
        self.stack[self.count] = 0
        self.minStack[self.count] = 0
        return popped 

    def top(self) -> int:
        return self.stack[self.count - 1]

    def getMin(self) -> int:
        return self.minStack[self.count - 1] 

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
