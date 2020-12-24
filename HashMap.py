# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I have used one hash and linkedlist (linear chaining) to avoid collision


class MyHashMap:
    def __init__(self):
        """
        Initialize your data structure here.
        """

        self.size = 1000
        self.data = [None] * self.size

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = key % self.size

        if self.data[index] == None:
            self.data[index] = ListNode(key, value)
        else:
            currentNode = self.data[index]
            temp = currentNode
            self.data[index] = ListNode(key, value)
            self.data[index].next = currentNode

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = key % self.size
        if self.data[index] == None:
            return -1
        else:
            currentNode = self.data[index]
            while currentNode:
                if currentNode.key == key:
                    return currentNode.val
                currentNode = currentNode.next
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = key % self.size
        if self.data[index] == None:
            return
        else:
            currentNode = self.data[index]
            while currentNode:
                if currentNode.key == key:
                    currentNode.val = -1
                currentNode = currentNode.next


class ListNode:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
