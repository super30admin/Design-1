# 705. Design HashSet

# Design a HashSet without using any built-in hash table libraries.

# Implement MyHashSet class:

#     void add(key) Inserts the value key into the HashSet.
#     bool contains(key) Returns whether the value key exists in the HashSet or not.
#     void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.


# Approach:
# - The HashSet is implemented using an array of linked lists (separate chaining).
# - Each array index serves as a bucket that can store multiple elements in a linked list.
# - The hash function is a simple modulo operation (key % array_length).
# - Each bucket starts with a dummy head node to simplify operations.

# Time Complexity (overall):
# - Average case (good hash distribution): O(1) for all operations
# - Worst case (all keys hash to the same index): O(N) for all operations where N is the number of elements

# Space Complexity:
# - O(M + N) where M is the size of the array (10^4) and N is the number of elements stored

# Did this code successfully run on Leetcode : YES

class ListNode:
    # Defining a node class for our linked list implementation
    def __init__(self, key):
        self.key = key # Store the key value
        self.next = None # Initialize the next pointer to None (end of the list)

class MyHashSet(object):
    def __init__(self):
        # Creating an array of 10^4 buckets, with a dummy head node
        # The dummy head simpliefies insertion and deletion operations
        self.set = [ListNode(0) for i in range(10**4)]

    def add(self, key):
        # Find the appropriate bucket using the hash function (key % array_length)
        current = self.set[key % len(self.set)]
        # Traverse the linked list to check if the key already exists
        while current.next:
            # If the key is found, exit the function without adding (no duplicates allowed)
            if current.next.key == key:
                return 
            # Move to the next node in the linked list
            current = current.next

        # If we've reached the end of the list without finding the key,
        # add a new node with the key at the end of the list
        current.next = ListNode(key)

    def remove(self, key):
        # Find the appropriate bucket using the hash function
        current = self.set[key % len(self.set)]
        # Traverse the linked list to find the key
        while current.next:
            # If the key is found in the next node
            if current.next.key == key:
                # Remove the node by updating the current node's next pointer
                # to skip over the node we want to remove
                current.next = current.next.next
                return # Exit once the key is removed

            # Move to the next node in the linked list
            current = current.next

    def contains(self, key):
        # Find the appropriate bucket using the hash function
        current = self.set[key % len(self.set)]
        # Traverse the linked list to search for the key
        while current.next:
            # If the key is found, return True
            if current.next.key == key:
                return True
            # Move to the next node in the linked list
            current = current.next

        # If we've traversed the entire list without finding the key, return False
        return False
        
