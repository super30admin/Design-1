# Design Min stack
# Time complexity : O(1)
# Space Complexity : O(1)
# submitted in leetcode
# After watching the video I realized that I dnt need to maintain the counter since I can store the min value in variable 
# and use peek function
class MinStack:

    def __init__(self):
        self.data = [None]*100000
        self.min_stack = [None]* 100000
        self.counter1 = -1
        self.counter2 = -1
        

    def push(self, val: int) -> None:
        self.counter1 += 1
        self.data[self.counter1] = val
        if self.counter2 == -1 or val <= self.getMin():
            self.counter2 += 1
            self.min_stack[self.counter2] = val
            


    def pop(self) -> None:
        val = self.data[self.counter1]
        self.counter1 -=1
        if val == self.min_stack[self.counter2]:
            self.counter2 -=1
        return val



    def top(self) -> int:
        return self.data[self.counter1]
        

    def getMin(self) -> int:
        return self.min_stack[self.counter2]



        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()