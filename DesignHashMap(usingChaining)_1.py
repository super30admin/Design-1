# accepted in leetcode
# time complexity - O(1) for hashmap, for chaining in hashmap - O(N)
# Tried to use private method for finding the element but was unsuccessful.
# created new listnode class having (key, value) pair as python set and next node as class variable.
class ListNode:
    def __init__(self, key, val):
        self.pair = (key, val)
        self.next = None


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        Declared the size of array as 10000 and created an empty array.
        """
        self.size = 10000;
        self.arr = [None] * self.size

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: void
        """
        index = key % self.size  # calculated hash value
        if self.arr[index] == None:
            # checking if the particular array position has value or not. If not then inserting te new key and value pair
            self.arr[index] = ListNode(key, value)
        else:  # if we have an existing element
            cur = self.arr[
                index]  # initializing a curr pointer for creating or checking for linked list at the position.
            while cur:  # iterating through linkedlist
                if cur.pair[0] == key:  # if the key is same as current index, update with new value.
                    cur.pair = (key, value)  # update
                    return
                if cur.next == None: break
                cur = cur.next
            cur.next = ListNode(key, value)  # if key not found, creating a new linked listnode at the array

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        index = key % self.size  # calculated hash value
        cur = self.arr[index]  # initializing a curr pointer for creating or checking for linked list at the position.
        while cur:  # iterating through linkedlist
            if cur.pair[0] == key:  # if the key is same as current index, return the value.
                return cur.pair[1]
            cur = cur.next  # else go to next listnode
        return -1  # if not found return -1

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: void
        """
        index = key % self.size  # calculated hash value
        cur = prev = self.arr[index]  # initializing a curr and prev pointer.
        if not cur: return  # if key doesnt exist return
        if cur.pair[0] == key:  # if found get the next linkedlist element to current position
            self.arr[index] = cur.next
        else:  # if not found check in linked list
            cur = cur.next
            while cur:
                if cur.pair[0] == key:  # if found make a connection from previous to next element.
                    prev.next = cur.next
                    break
                else:
                    cur, prev = cur.next, prev.next
