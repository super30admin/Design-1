# Time Complexity : O(1) for push, pop, top, and getMin
# Space Complexity : O(N) for the size of the stack (number of elements pushed into stack) O(2N since we used two stacks)
                #but O(N) nontheless
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : A little bit.. had I not drawn what I was about 
#                                           to implement, I would've been stuck for a long time 


# Your code here along with comments explaining your approach
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        #two stacks, one regular and one that keeps count of the smallest value in our stack
        self.mainStack = []
        self.minStack = []

    def push(self, x: int) -> None:
        #if both stacks are empty 
        if not self.mainStack and not self.minStack:
            self.mainStack.append(x)
            self.minStack.append(x)
        #if one of the stacks are not empty
        else:
            self.mainStack.append(x)
            #if the value we are pushing is less than the top val in the minStack then we put the value onto the minStack
            if x <= self.minStack[-1]:
                self.minStack.append(x)
            
    def pop(self) -> None:
        #if there are items in minStack and mainStack
        if self.mainStack and self.minStack:
            check = self.mainStack.pop()
            #if the last value on the mainStack so happens to be also the top value on the minStack..pop it
            if check == self.minStack[-1]:
                self.minStack.pop()

    def top(self) -> int:
        #returns the last value pushed into the stack
        return self.mainStack[-1]

    def getMin(self) -> int:
        #return the top of the minStack since it holds the minimal value of the stack
        return self.minStack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()