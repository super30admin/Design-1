# // Time Complexity :
# Average time complexity to insert O(1), {worst case O(n) this only happens if the hash function designed is really bad , as we generally use hashing along with main a linked list
# // Space Complexity :
# O(n) -> one for the initial array O(n) + one for the linked list O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach
# I have initally taken a bounded list of size 1000
#  performed hashing to bound the size
#  incase of any collions i have used a linked list to maintain all the keys and values in linked list in case of collion
class Node:

    def __init__ (self, data):
        self.data = data
        self.next = None

class MyHashMap:

    def __init__(self):
# Created a bounded list which acts as hashmap
        self.hashmap = [None] * 1000

    def _hash(self, data):

# hashed the key incase of keys not being an integer and performed hashing by using size of initial hashmap taken

        return hash(data) % 1000

    def put(self, key, value):
# created the hash for the key to get the index of the key
#checked if list is empty, then created a new node
#else traversed the linked list to find the key, if found updated the values else created new node at the end
        block = self._hash(key)
        if self.hashmap[block] is None:
            self.hashmap[block] = Node((key, value))
        else:
            current = self.hashmap[block]
            while current:
                k, v = current.data
                if k == key:
                    current.data = (key, value)
                    return
                if current.next is None:
                    break
                else:
                    current = current.next
            current.next = Node((key, value))




    def get(self, key):
# created the hash for the key to get the index of the key
#checked if list is empty, then returned -1
#else traversed the linked list to find the key, if found returned the value else returned -1
        block = self._hash(key)
        if self.hashmap[block] is None:
            return -1
        current = self.hashmap[block]
        while current:
            k, v = current.data
            if k == key:
                return v
            current = current.next
        return -1

    def remove(self, key):
# created the hash for the key to get the index of the key
#checked if list is empty, then returned
#else created a dummyNode and pointed it to first node and made first node as dummynode to identify whether next node matches with the key
#if matched pointed the node to next node
        block = self._hash(key)
        if self.hashmap[block] is None:
            return

        current = self.hashmap[block]

        dummyNode = Node(0)
        dummyNode.next = current

        cur = dummyNode
        while cur and cur.next:
            k, v = cur.next.data
            if k == key:
                cur.next = cur.next.next
            cur = cur.next

        self.hashmap[block] = dummyNode.next
