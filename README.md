# Design-1

## Problem 1:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dict = {}

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        self.dict[key] = value
        # print(key)
        # print(value)

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        if key in self.dict:
            return self.dict[key]
        else:
            return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        self.dict.pop(key,None)
        self.dict[key] = -1


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)



## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)

import math
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.checkmin = math.inf
        
    def push(self, x: int) -> None:
        if x <= self.checkmin:
            self.stack.append(self.checkmin)
            self.checkmin = x
        self.stack.append(x)
        
        
    def pop(self) -> None:
        # s = self.stack.pop()
        # if self.stack[-1] == self.checkmin:
        #     self.checkmin = self.stack.pop()
        
        if self.stack[-1] == self.checkmin:
            self.stack.pop()
            self.checkmin = self.stack[-1]
        self.stack.pop()
        
    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.checkmin


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()



