# Time Complexity :
# add - O(1) amortized
# remove - O(1) amortized
# contains - O(1) amortized

# Space Complexity : O(n) for n distinct elements due to supporting data structure - array and linked list

# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
"""
Core data structure is an array, with size of 10,000, with a single linked list at each node.
Created supporting ListNode class to support the linked list at each index of the array - set.
When collision occurs we add to the linked list located at the array's index the has function resolved to.

Simple hash function which given an integer with mod operation always maps to an array idx between 0 to 9999

Add - hash incoming key to index, iterate on linked list and index and add the new key
Remove - hash incoming key to index, iterate on linked list to locate key, remove by setting next of key to the element after
Contains - has incmong key to index, traverse linked list, return true when found, else false
"""

class ListNode:
    def __init__(self, key):
        self.key = key
        self.next = None

class MyHashSet:
    def __init__(self):
        # LC Problem says that there can be 10^4 calls for all operations, init data structure with that size
        self.set = [ListNode(0) for i in range (10**4)] 

    def add(self, key: int) -> None:
        index = key % len(self.set)
        curr = self.set[index]

        while curr.next:
            if curr.next.key == key: # detect duplicates and immediately return
                return
            curr = curr.next
        curr.next = ListNode(key) # else traverses and adds after last element


    def remove(self, key: int) -> None:
        index = key % len(self.set)
        curr = self.set[index]

        while curr.next:
            if curr.next.key == key: 
                curr.next = curr.next.next # removes element by pointing next of element to the element after
                return
            curr = curr.next


    def contains(self, key: int) -> bool:
        index = key % len(self.set)
        curr = self.set[index]

        while curr.next:
            if curr.next.key == key: 
                return True # return true when found
            curr = curr.next
        return False # if iteration completes and element not found, return false

