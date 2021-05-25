# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach



class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
    
    #append val to top of stack
    def push(self, val: int) -> None:
        self.stack.append(val)
        
    #pop the top ele from the stack
    def pop(self) -> None:
        if self.stack:
            self.stack.pop()
    
        
    #return top element from stack
    def top(self) -> int:
        return self.stack[-1]

    #min func returns minimum ele in the stack defined
    def getMin(self) -> int:
        return min(self.stack)


obj = MinStack()
obj.push(1)
obj.push(2)
obj.push(3)
print('Min ',obj.getMin())
obj.push(-1)
print('top ',obj.top())
obj.pop()
obj.pop()
print('Min ',obj.getMin())
print('top ',obj.top())

