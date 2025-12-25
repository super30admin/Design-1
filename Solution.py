## Design -1 
## Problem 1:(https://leetcode.com/problems/design-hashset/)
# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class MyHashSet(object):

    def __init__(self):
        self.primary= 1000
        self.nested = 1001
        self.storage = [None] * self.primary

    def hash1(self,key):
        return key% self.primary
    
    def hash2(self,key):
        return key/self.nested

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        ## checking if key in primary
        bucket = self.hash1(key)
        nestedbucket = self.hash2(key)

        if self.storage[bucket] == None:
            self.storage[bucket] = [False]*self.nested
        
        self.storage[bucket][nestedbucket] = True

        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.hash1(key)
        nestedbucket = self.hash2(key)

        if self.storage[bucket] == None:
            return
        self.storage[bucket][nestedbucket] = False


    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        bucket = self.hash1(key)
        nestedbucket = self.hash2(key)

        if self.storage[bucket] == None:
            return False
        return self.storage[bucket][nestedbucket]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

####################################################


# Problem 2:
# Design MinStack (https://leetcode.com/problems/min-stack/)
# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


class MinStack(object):

    def __init__(self):
        self.stack = deque()
        self.minstack = deque()
        self.min = float('inf')
        self.minstack.append(self.min)
    
    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.stack.append(val)
        if val <= self.min:
            self.minstack.append(val)
            self.min = val
        
        

    def pop(self):
        """
        :rtype: None
        """
        val = self.stack.pop()
        if val == self.min:
            self.minstack.pop()
            self.min = self.minstack[-1]
        


    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()