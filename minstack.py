# Time Complexity : O(1)
# Space Complexity : O(N) for all N elements
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : The time complexity was a little tricky to 
# understand as the push operation takes O(1), instead of O(N) time



class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.mystack = []

        
    def push(self, val: int) -> None:
        if not self.mystack:
            self.mystack.append([val, val])
        else:
            current_min = self.getMin()
            self.mystack.append([val, min(current_min, val)])
       
    
    def pop(self) -> None:
        self.mystack.pop()
        

    def top(self) -> int:
        return self.mystack[-1][0]
        
        
    def getMin(self) -> int:
        return self.mystack[-1][1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()