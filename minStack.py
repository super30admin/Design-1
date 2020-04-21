#Time Complexity : pop:O(1), top:O(1) , push:O(1), getMin: O(1)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this :In calculating space and time complexity, I am not sure about the complexities I have mentioned above


# Your code here along with comments explaining your approach


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack=list() #initialize stack using list

    def push(self, x: int) -> None:
    #obtain element with minimum value
        minVal=self.getMin()
        #check if the minimum value exits and the number to be pushed on stack is lesser than the minimum value obtained.
        if minVal is None or x< minVal:
            minVal=x# if x is lesser then min value, we update the min value
        self.stack.append((x,minVal))# appens the list with the min value at index 1.
            

    def pop(self) -> None:
        if len(self.stack) !=0:#check if the stack is non empty
            self.stack.pop()#pop the element present at top of the stack

    def top(self) -> int:
        return self.stack[-1][0]# return the top most element in the stack
        

    def getMin(self) -> int:
        
        if len(self.stack) !=0:
            return self.stack[-1][1]# return the element in index 1 as it conatins min value as we push min value to the index 1 in a tuple
        else:
            return None

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

