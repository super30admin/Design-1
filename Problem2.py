# Time Complexity : push -> O(1) pop -> o(1) top -> O(1) getMin -> O(1)
# Space Complexity : O(n) n is number of operations
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I did this problem already so there was
# no problem but first time i tried for so long and refered the solution(it was long back)

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = 0
        

    def push(self, val: int) -> None:
        if len(self.stack) == 0:
            self.min = val
            self.stack.append(val)
        else:
            if self.min > val:
                self.stack.append(2*val - self.min)
                self.min = val
            else:
                self.stack.append(val)

    def pop(self) -> None:
        if len(self.stack) == 0:
            return None
        if self.stack[len(self.stack)-1] <= self.min:
            x = self.min
            self.min = 2*self.min - self.stack[len(self.stack)-1]
            self.stack.pop()
            return x
        else:
            return self.stack.pop()

    def top(self) -> int:
        if len(self.stack) == 0:
            return None
        x = self.stack[len(self.stack) - 1]
        if x < self.min:
            return self.min
        else:
            return x

    def getMin(self) -> int:
        if self.top() == None:
            return None
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()