# Time Complexity:
# - add: O(1) on average
# - remove: O(1) on average
# - contains: O(1) on average
#   (Assuming a good hash distribution and limited collisions)
#
# Space Complexity: O(n + c), where
# - n is the number of elements
# - c is the capacity of the hash set (initial array size)
#
# Successfully ran on Leetcode: Yes
# Challenges faced: Initial conceptual understanding of hashing and chaining was difficult


class Node():
    def __init__(self,key):
        self.key = key
        self.next = None

class MyHashSet(object):

    def __init__(self):
        self.hash_set = [Node(i) for i in range(10**4) ]

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        idx = key%len(self.hash_set)
        idx_node = self.hash_set[idx]
        while idx_node.next:
            if idx_node.next.key == key:
                return
            idx_node = idx_node.next
        idx_node.next = Node(key)



    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        idx = key%len(self.hash_set)
        idx_node = self.hash_set[idx]
        while idx_node.next:

            if idx_node.next.key == key:
                idx_node.next = idx_node.next.next
                return
            idx_node = idx_node.next

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        idx_node = self.hash_set[key%len(self.hash_set)]
        while idx_node.next:
            if idx_node.next.key == key:
                return True
            idx_node = idx_node.next

        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)