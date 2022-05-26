"""
- Passed test cases on Leetcode
"""

class Node(object):

    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap(object):

    def __init__(self):
        self.arr = [None for i in range(10000)]

    def IndexValue(self, key):
        return key % 10000

    def ElementValue(self, key):

        # O(1) in best case Time Complexity
        # O(1) in best case Space Complexity

        index = self.IndexValue(key)

        if (self.arr[index] == None):
            dummyNode = Node(-1, -1)
            self.arr[index] = dummyNode
            return dummyNode

        currentNode = self.arr[index]

        while (currentNode.next != None):
            if (currentNode.next.key == key):
                return currentNode
            currentNode = currentNode.next

        return currentNode

    def put(self, key, value):
        
        # O(1) in best case Time Complexity
        # O(1) in best case Space Complexity

        currentNode = self.ElementValue(key)
        if (currentNode.next == None):
            currentNode.next = Node(key, value)
        else:
            currentNode.next.value = value
        return

    def get(self, key):
        
        # O(1) in best case Time Complexity
        # O(1) in best case Space Complexity

        currentNode = self.ElementValue(key)
        if (currentNode.next != None):
            return currentNode.next.value
        else:
            return -1

    def remove(self, key):
       
        # O(1) in best case Time Complexity
        # O(1) in best case Space Complexity

        currentNode = self.ElementValue(key)
        if (currentNode.next != None):
            currentNode.next = currentNode.next.next
        return

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)