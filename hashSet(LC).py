# Hashset using Linear Chaining (Linked List)
# TC: O(1) For each method (Add, remove, contains)
# SC: O(N) , N is the number of elements in the set, because the space used by the buckets is small unless the load factor is very low
class ListNode:
    def __init__(self, key):
        self.key = key
        self.next = None


class MyHashSet:

    def __init__(self, size=10000):
        self.size = size
        self.buckets = [None] * self.size  # Array of linked lists

    def hash(self, key):
        return key % self.size  # Hash function to get the index

    # Find the node with the given key in the linked list
    def find_node(self, index, key):
        prev = self.buckets[index]
        curr = prev.next

        while curr and curr.key != key:
            prev = curr
            curr = curr.next

        return prev

    # Add a key to the HashSet
    def add(self, key):
        index = self.hash(key)  # Get the index using the hash function

        # If no linked list exists at this index, create a dummy head
        if self.buckets[index] is None:
            self.buckets[index] = ListNode(-1)  # Dummy node

        # Find the node in the linked list
        prev = self.find_node(index, key)

        if prev.next is None:
            # Key does not exist, add a new node with the key
            prev.next = ListNode(key)

    # Remove the key from the HashSet
    def remove(self, key):
        index = self.hash(key)

        if self.buckets[index] is None:
            return  # Key does not exist

        prev = self.find_node(index, key)

        if prev.next is not None:
            prev.next = prev.next.next  # Remove the node by skipping it

    # Check if the key exists in the HashSet
    def contains(self, key):
        index = self.hash(key)

        if self.buckets[index] is None:
            return False  # Key does not exist

        prev = self.find_node(index, key)

        return prev.next is not None  # If the next node exists, the key is in the set


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(1000000)  # Edge case
print(obj.contains(1))  # True
print(obj.contains(1000000))  # True
obj.remove(1)
print(obj.contains(1))  # False
