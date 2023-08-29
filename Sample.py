# Time Complexity : 132MS, 32 MS RESPECTIVELY
# Space Complexity : 18MB, 16.8 MB RESPECTIVELY
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : 

# Accepted  Python 132 ms  18 MB
# Accepted Python 32 ms 16.8 MB

#Your code here along with comments explaining your approach
#1.DESIGN HASHSET
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.capacity = 1000  # Choose a suitable capacity for your HashSet
        self.data = [None] * self.capacity

    def _hash(self, key):
        return key % self.capacity

    def add(self, key):
        """
        Add a key to the HashSet.
        :type key: int
        :rtype: None
        """
        index = self._hash(key)
        if self.data[index] is None:
            self.data[index] = []
        if key not in self.data[index]:
            self.data[index].append(key)

    def remove(self, key):
        """
        Remove a key from the HashSet if it exists.
        :type key: int
        :rtype: None
        """
        index = self._hash(key)
        if self.data[index] is not None and key in self.data[index]:
            self.data[index].remove(key)

    def contains(self, key):
        """
        Check if the HashSet contains a key.
        :type key: int
        :rtype: bool
        """
        index = self._hash(key)
        return self.data[index] is not None and key in self.data[index]

# Example usage:
myHashSet = MyHashSet()
myHashSet.add(1)
myHashSet.add(2)
print(myHashSet.contains(1))  # Should return True
print(myHashSet.contains(3))  # Should return False
myHashSet.add(2)
print(myHashSet.contains(2))  # Should return True
myHashSet.remove(2)
print(myHashSet.contains(2))  # Should return False
# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)






#MINISTACK

class MinStack:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.main_stack = []  # Stack to store elements
        self.min_stack = []   # Stack to track minimum values

    def push(self, val):
        """
        Pushes the element val onto the stack.
        :type val: int
        :rtype: None
        """
        self.main_stack.append(val)  # Push the element onto the main stack
        
        # Update the minimum stack with the new minimum value if necessary
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)

    def pop(self):
        """
        Removes the element on the top of the stack.
        :rtype: None
        """
        if self.main_stack:
            # Check if the element being removed is the current minimum
            if self.main_stack[-1] == self.min_stack[-1]:
                self.min_stack.pop()
            self.main_stack.pop()

    def top(self):
        """
        Gets the top element of the stack.
        :rtype: int
        """
        if self.main_stack:
            return self.main_stack[-1]

    def getMin(self):
        """
        Retrieves the minimum element in the stack.
        :rtype: int
        """
        if self.min_stack:
            return self.min_stack[-1]

# Example usage:
minStack = MinStack()
minStack.push(-2)
minStack.push(0)
minStack.push(-3)
print(minStack.getMin())  # Should return -3
minStack.pop()
print(minStack.top())     # Should return 0
print(minStack.getMin())  # Should return -2
