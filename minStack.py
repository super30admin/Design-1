#Time Complexity = add: O(1), remove: O(1), contains: O(1)
#Space Complexity = add: O(1), remove: O(1), contains: O(1)
class MinStack:

# Declare 2 empty arrays one to store elements and the other only when min values occour
    def __init__(self):
        self.stack = []
        self.min = []
        

    def push(self, val: int) -> None:
        #push the value at the end and also if the top of min value array is more than pushed value insert it into min stack 
        self.stack.append(val)
        if not self.min or val <= self.min[-1]:
            self.min.append(val)
        

    def pop(self) -> None:
        #pop top element from both the lists when the top value from stack and minstack are the same, else only remove from the stack 
        if not self.stack:
            return None
        
        popVal = self.stack.pop()

        if popVal == self.min[-1]:
            self.min.pop()
        
        return popVal
        

    def top(self) -> int:
        #return top of the list
        if not self.stack:
            return None
        return self.stack[-1]
        

    def getMin(self) -> int:
        #return the top of the minstack

        if not self.min:
            return None
        return self.min[-1]