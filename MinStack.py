"""
Runtime Complexity:
1) Idea - We initialise two stack arrays to perform getMin() operation. Min stack returns the min in O(1) instead of a normal stack which takes O(n).
2) push(), pop(), top() operation takes O(1) time because we are not traversing the elements in the array and all we do is append, pop, return top from the end without affecting the position of other elements.
3) getMin() works in O(1) as well, as the first/top element of the min stack is returned.
4)Yes, the code worked on leetcode.
"""


class MinStack:

    def __init__(self):
        self.stack =[]
        self.min_stack = []
        
        

    def push(self, val: int) -> None:
       self.stack.append(val)
       if not self.min_stack or self.min_stack[-1]>=val:
            return self.min_stack.append(val)

    def pop(self) -> None:
        if self.min_stack[-1] ==self.stack.pop():
            self.min_stack.pop()

    def top(self) -> int:
        
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]
        


# Your MinStack object will be instantiated and called as such:
#obj = MinStack()
#obj.push(self,val)
#obj.pop()
#param_3 = obj.top()
#param_4 = obj.getMin()
