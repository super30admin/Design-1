# Time Complexity : O(1) - get_ind. O(n) - find_node function where n is the length of the linked list at that
# particular entry - arr[ind]. Also, put, get and remove functions - as they internally call find_node
# Space Complexity : O(an) - a : length of the array and n is the length of the longest linked list out of all lists at each ind of arr.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Was confused whether to initialise arr with None values or with dummy nodes
#
#
# Your code here along with comments explaining your approach

class MyHashMap:

    # This is a nested class to define the structure of the node of the linked list
    class ListNode:
        def __init__(self, key, value):
            self.key = key
            self.data = value
            self.next = None

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # Initialise array of size 10,000 - arbitarily chosen with None values
        self.arr = [None] * 10000

    # This implements the hash function. Returns the ind at which we have to insert the value
    def get_ind(self, key):
        return key % 10000

    # This returns the pointer to the node after which the value must be inserted / deleted / returned.
    def find_node(self, key, ind):
        # If the arr[ind] is empty then assign a dummy node to it. The actual linked list starts after this node.
        if self.arr[ind] is None:
            self.arr[ind] = MyHashMap.ListNode(-1, -1)
            return self.arr[ind]
        # Else we have to go through the linked list till we find the key
        else:
            prev_node = self.arr[ind]
            while prev_node.next is not None and prev_node.next.key != key:
                prev_node = prev_node.next
            return prev_node

    # This is insertion function. If the node from find_node is null then we create a new node else, the node (next node) already exists and we
    # simply update it.
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        ind = self.get_ind(key)
        prev_node = self.find_node(key, ind)
        if prev_node.next is None:
            prev_node.next = MyHashMap.ListNode(key, value)
        else:
            prev_node.next.data = value

    # This is a retreival function. If node from find_node function is null, we return -1 else we return the next node's value.
    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        ind = self.get_ind(key)
        node = self.find_node(key, ind)
        if node.next is None:
            return -1
        else:
            return node.next.data

    # This is deletion function. If node from find_node is null, then it means node doesn't exist and we don't do anything. Else, we remove the
    # next node's linkage.
    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        ind = self.get_ind(key)
        prev_node = self.find_node(key, ind)
        if prev_node.next is not None:
            prev_node.next = prev_node.next.next

