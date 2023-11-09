# Design Hashsets without any built-in hash table libraries. Leet Code 705
# Using LinkedList to avoid collisions.
# Time complexity in the average case is O(1). Space complexity is O(n)

class ListNode:
    def __init__(self, key):
        self.key = key
        self.next = None

class MyHashSet:
    def __init__(self):
        self.arr = [ListNode(0) for i in range(10**4)]       # To create new list Dummy position for every position in array

    def add(self, key: int) -> None:
        index = key % len(self.arr)                          # Hash function: index is the position where the key will be mapped to based on the value it gets after mod with length of array
        pointer = self.arr[index]                            # pointer head of the LinkedList
        while pointer.next:                                  # Checking if head is not null
            if pointer.next.key == key:                      # Check for duplicate based on passed key at the next position
                return
            pointer = pointer.next                           # Loop through till we don't get to the end of the Linked List
        pointer.next = ListNode(key)

    def remove(self, key: int) -> None:
        index = key % len(self.arr)                          # Hash function: index is the position where the key will be mapped to based on the value it gets after mod with length of array
        pointer = self.arr[index]                            # pointer head of the LinkedList
        while pointer.next:                                  # Checking if head is not null
            if pointer.next.key == key:                      # Check for duplicate based on passed key at the next position
                pointer.next = pointer.next.next             # Move the pointer ahead to remove the matched key consisting Node
                return
            pointer = pointer.next                           # Loop through till we don't get to the end of the Linked List

    def contains(self, key: int) -> bool:
        index = key % len(self.arr)                          # Hash function: index is the position where the key will be mapped to based on the value it gets after mod with length of array
        pointer = self.arr[index]                            # pointer head of the LinkedList
        while pointer.next:                                  # Checking if head is not null
            if pointer.next.key == key:                      # Check for duplicate based on passed key at the next position
                return True                                  # Returning True if we find the key
            pointer = pointer.next                           # Loop through till we don't get to the end of the Linked List
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)