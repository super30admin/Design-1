#We first initiate a list and a new list to keep track of minimum
# For push we append the new value to stack_list and check whether it is smaller with minimum list
# For pop we pop the value and check the new minimum value from min list and if the popped value is equal to minimum then we assign next minimum value
# For top we just return the last element
# For getMin we use the min list
#Time Complexity = O(1)
#Space Complexity = O(1)

class MinStack:

    def __init__(self):
        self.stack = []
        self.min = []
        

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.min or self.min[-1]>=val:
            self.min.append(val)

 

    def pop(self) -> None:
        if self.stack:
            if self.stack[-1] == self.min[-1]:
                self.min.pop()
            self.stack.pop()


        

    def top(self) -> int:
        return self.stack[-1] if self.stack else None
        

    def getMin(self) -> int:
        return self.min[-1] if self.min else None
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()