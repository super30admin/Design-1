"""Time Complexity : Push = O(1), Pop = O(1), getMin = O(1)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach

"""
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []        
        self.mini = float("inf")

    def push(self, x: int) -> None:
        
        """
        If the inserted element is less than the minimum element, we will be adding minimum element and the current element to the stack.
        Assign new element to the minimum element.
        """
        if x <= self.mini:
            self.stack.append(self.mini)
            self.mini = x
        self.stack.append(x)
            
    def pop(self) -> None:

        """
        if the popped element is minimum elelment, pop again and assign it as minimum element (as we have pushed next minimum element in to stack)
        """
        ele = self.stack.pop()
        if ele==self.mini:
            self.mini = self.stack.pop()
        

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.mini


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
