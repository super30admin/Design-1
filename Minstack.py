# Time COmplexity : O(n)
# Space Complexity: 

# Have you seen it on leetcode: yes 
# My code and approach:
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = list()                                             # Declared two stack
        self.min = list()

    def push(self, val: int) -> None:
        self.stack.append(val)                                          # Add val to stack
        if len(self.min) == 0 or val <= self.min[-1]:                   # Gave 2 conditoin to push in min stack
                self.min.append(val)
        
    def pop(self) -> None:
        tmp = self.stack.pop()                                          # Pop from the stack
        if tmp == self.min[-1]:                                         # If the pop element is similiar to min stack it will pop to
            self.min.pop()

    def top(self) -> int:                                               # top fuction, it will just show the above element
        return self.stack[-1]
        

    def getMin(self) -> int:                                            # It will give the minimum element
        return self.min[-1]
        
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()