# // Time Complexity : push, pop, top :  O(1) | getMin : O(nlogn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no
class MinStack:
    def __init__(self):
        self.minstack = []
        self.s = []
        
    def push(self, val: int) -> None:
        self.minstack.append(val)

    def pop(self) -> None:
        self.minstack.pop(-1)

    def top(self) -> int:
        print(self.minstack,"min")
        return self.minstack[-1]

    def getMin(self) -> int:
        self.s[:] = self.minstack
        self.s.sort() # nlogn for python inbuilt sort function
        return self.s[0]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()