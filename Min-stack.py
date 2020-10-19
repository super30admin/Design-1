#  Time Complexity : O(1) for all the operations Except getMin. getMin has O(n)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : Tried in JAVA but couldn't complete hence solved in python
#  Your code here along with comments explaining your approac


import collections

class MinStack:
    
    def __init__(self):
        """
        initialize your data structure here.
        """
        #using the queue in python for storing
        self.q = collections.deque()


    def push(self, x: int) -> None:
        self.q.append(x)

    def pop(self) -> None:
        return self.q.pop()

    def top(self) -> int:
        return self.q[-1]

    def getMin(self) -> int:
        return min(self.q)


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()