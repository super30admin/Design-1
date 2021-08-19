"""
Time Complexity:O(1) for everything
Space Complexity: O(n)
Here we will be taking two arrays one with value stack and other we can call as minstack.
we will populate the minimum value stack with infinity. For pushing the minimum value we will check
the minimum out of the value and the current minimum value which is minimum we will it append it to minimum
stack and we will push the value into the value stack. For popping we will remove both the top elements at
minimum stack and value stack and reassign the min value to the top of minimum stack. For checking the top we will
just check the top value of the value stack and for retrieving the minimum value we will just see the minimum value
Ran on leetcoe-yes

"""

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.valueStack = []
        self.minStack=[]
        self.minvalue=float('inf')
        self.minStack.append(self.minvalue)

    def push(self, val: int) -> None:
        self.minvalue=min(val, self.minvalue)
        self.valueStack.append(val)
        self.minStack.append(self.minvalue)

        # self.stack.append(val)
        # if self.stack==[]:
        #     self.stack.append(val)
        #
        # elif val >= self.getMin():
        #     self.stack.append(val)
        # else:
        #     self.stack.append(2*val - self.getMin())


    def pop(self) -> None:
        self.valueStack.pop()
        self.minStack.pop()
        self.minvalue=self.minStack[-1]


    def top(self) -> int:

        return self.valueStack[-1]

    def getMin(self) -> int:

        return self.minvalue



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()