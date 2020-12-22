# Approach: Implemented the min stack with the data structure 'array' similar to precourse 1 problem (Implement stack using array)
# Choice: When we implemented stack using array, the methods push, pop, peek etc all ran in constant space and time
# We declare a minStack which holds the min value at every instant 
# since we need to keep track of this minimum value everytime we push a new element or pop off an element, the min value will keep changing
# Time Complexity : O(1) # append, pop peek all are constant time operations
# Space Complexity : O(1) ## append, pop peek all are constant space operations
# Succesfully ran in leetcode
# Base Case: Not considering an empty stack as constraint mentions non-empty stack

# Doubt: I have declared a minStack [] but that only holds the min value appended for every push method. 
# I mentioned O(1), since if methods push/pop are run independantly it is hardly storing one value(append) or popping one val at a time, which is constant space/time
# Should I mention this as the case or the overall when we need to perform on 'n' such elements in the stack? Not quite sure

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minStack = []
        

    def push(self, x: int) -> None:
        """
        declare the new min variable and check if min stack holds values.
        If it does, we need to compare the current number to be pushed with recent entry in min stack in order to update min value
        In either case (whether min stack holds values or is empty, append the min value to the min stack and append number to stack)
        """
        new_min = x
        if self.minStack:
            last_min = self.minStack[-1]
            new_min = min(last_min, x)
        
        self.minStack.append(new_min)
        self.stack.append(x)



    def pop(self) -> None:
        """
        In order to keep track of the min values, while popping the value we also need to pop off its corresponding min value
        """
    
        self.minStack.pop()
        return self.stack.pop()
        

    def top(self) -> int:
        """
        return last element from [] or top element from stack (LIFO)
        """
        return self.stack[-1]
        

    def getMin(self) -> int:
        """
        return last entry from min stack
        """
        return self.minStack[-1]
        


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(3)
obj.push(4)
obj.push(6)
# obj.pop()
top_val = obj.top()
print(top_val)
min_val = obj.getMin()
print(min_val)