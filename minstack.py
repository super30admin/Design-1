# 1. Implemented before class with below leetcode result.
# Runtime: 612 ms, faster than 12.93% of Python3 online submissions for Min Stack.
# Memory Usage: 18 MB, less than 44.72% of Python3 online submissions for Min Stack.

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = [] 
        self.top_ptr = -1
        
    def push(self, x: int) -> None: # O(1)
        self.top_ptr += 1
        self.stack.append(x)
        
    def pop(self) -> None: # O(1)
        self.top_ptr -= 1
        self.stack = self.stack[:-1]
        
    def top(self) -> int: # O(1)
        return self.stack[self.top_ptr]

    def getMin(self) -> int: # O(n) since stack is sorted everytime
        return min(self.stack)


# 2. with inbuilt functions <pop> below leetcode result.
#Runtime: 608 ms, faster than 15.12% of Python3 online submissions for Min Stack.
# Memory Usage: 18 MB, less than 65.31% of Python3 online submissions for Min Stack.

# 3. Implemented after class:
# Runtime: 56 ms, faster than 89.37% of Python3 online submissions for Min Stack.
# Memory Usage: 18.2 MB, less than 35.37% of Python3 online submissions for Min Stack.

import math
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minstack = []
        self.minstack.append(math.inf)
        
    def push(self, val: int) -> None:
        self.stack.append(val)
        if val < self.minstack[-1]:
            self.minstack.append(val)
        else:
            self.minstack.append(self.minstack[-1])
            
    def pop(self) -> None:
        self.stack.pop()
        self.minstack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minstack[-1]
