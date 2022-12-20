
#Time complexity: 
# Push, Pop, Top, getMin - O(1)

#Space complexity:
# Push, Pop, Top, getMin - O(1)

#Approach
# Use a single stack - instead of storing each mininmum, store a minimum variable and only modify it when minimum changes (both push and pop)
# When pushing - store min var, compare it to each push val, if val <= min, push twice, first cur minimum and then val
# When popping - compare each pop to min val, if popped val == min, pop twice and set min to the second pop, else pop once
# getMin - Simply return min variable
# Top - simply return top of the stack

#Accepted on Leetcode


class MinStack:

    def __init__(self):
        self.minStack = []
        self.min = float('inf')
        

    def push(self, val: int) -> None:
        if val <= self.min:
            self.minStack.append(self.min) #appending cur min
            self.min = val
            
        self.minStack.append(val) #appending val to be pushed

    def pop(self) -> None:
        popVal = self.minStack.pop()
        if popVal == self.min:
            self.min = self.minStack.pop()

    def top(self) -> int:
        return self.minStack[-1]
        

    def getMin(self) -> int:
        return self.min
        