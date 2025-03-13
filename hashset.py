# Approach:
# 1. We implement a hash set using **chaining with a linked list** to handle collisions efficiently.
# 2. The hash function (`key % bucket_size`) determines the index where elements are stored in an array of `bucket_size = 1999`.
# 3. Each bucket is a linked list where we perform insert (`add()`), delete (`remove()`), and search (`contains()`) operations in O(1) average time.


# Time Complexity:
# add(), remove(), contains() - O(1) -> average case, O(n) -> worst case
# Space Complexity: O(n) -> average case and worst case

class ListNode:
    """Linked list node to handle collisions."""
    def __init__(self, key, next_node=None):
        self.key = key
        self.next = next_node

class MyHashSet:

    def __init__(self):
        self.bucket_size = 1999
        self.buckets = [None] * self.bucket_size
    
    def _hash(self, key: int) -> int:
        """Hash function to compute bucket index."""
        return key % self.bucket_size

    def add(self, key: int) -> None:
        """Insert key into the HashSet."""
        index = self._hash(key)
        if not self.buckets[index]:
            self.buckets[index] = ListNode(key)
        else:
            curr = self.buckets[index]

            while curr:
                if curr.key == key:
                    return
                if not curr.next:
                    curr.next = ListNode(key)
                    return
                curr = curr.next

    def remove(self, key: int) -> None:
        """Remove key from the HashSet."""
        index = self._hash(key)
        curr = self.buckets[index]
        prev = None
        
        while curr:
            if curr.key == key:
                if prev:
                    prev.next = curr.next  # Bypass current node
                else:
                    self.buckets[index] = curr.next  # Remove head node
                return
            prev, curr = curr, curr.next

    def contains(self, key: int) -> bool:
        """Check if key exists in the HashSet."""
        index = self._hash(key)
        curr = self.buckets[index]
        while curr:
            if curr.key == key:
                return True
            curr = curr.next
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
