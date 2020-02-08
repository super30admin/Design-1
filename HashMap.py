"""
Solution:
1. Initialize an array of None values of size about 10000 and use one hash function (modulus) to retrieve the index
    located, and then perform chaining in case of collisions.
2. For all operations, traversing till the node before the actual key is mandatory and so put that functionality in a
    method (getElement).
3. Using getElement method, perform put (update the value if key already exists), get and remove operations.

--- Passed all test cases on Leetcode successfully
"""

class Node(object):

    def __init__(self, key, value):
        self.k = key
        self.v = value
        self.next = None


class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.array = [None for i in range(10000)]

    def getIndex(self, key):
        return key % 10000

    def getElement(self, key):

        # O(1) in best case and O(n) in worst case Time Complexity
        # O(1) in best case and O(n) in worst case Space Complexity

        index = self.getIndex(key)

        if (self.array[index] == None):
            dummyNode = Node(-1, -1)
            self.array[index] = dummyNode
            return dummyNode

        currentNode = self.array[index]

        while (currentNode.next != None):
            if (currentNode.next.k == key):
                return currentNode
            currentNode = currentNode.next

        return currentNode

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        # O(1) in best case and O(n) in worst case Time Complexity
        # O(1) in best case and O(n) in worst case Space Complexity

        currentNode = self.getElement(key)
        if (currentNode.next == None):
            currentNode.next = Node(key, value)
        else:
            currentNode.next.v = value
        return

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        # O(1) in best case and O(n) in worst case Time Complexity
        # O(1) in best case and O(n) in worst case Space Complexity

        currentNode = self.getElement(key)
        if (currentNode.next == None):
            return -1
        else:
            return currentNode.next.v

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        # O(1) in best case and O(n) in worst case Time Complexity
        # O(1) in best case and O(n) in worst case Space Complexity
        
        currentNode = self.getElement(key)
        if (currentNode.next != None):
            currentNode.next = currentNode.next.next
        return

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)