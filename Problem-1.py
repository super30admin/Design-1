"""
# Design-1

## Problem 1:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)


Design a HashMap without using any built-in hash table libraries.
To be specific, your design should include these functions: Follow up: How would you handle collisions in HashMap?
put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.


"""
class MyHashMap:

    class Node(object):   # create a class Node

        def __init__(self, key, val):   # construct and intialise attributes of class node
            self.key = key
            self.val = val
            self.next = None

    def __init__(self):         # construct a  hashlist example  table in our example
        self.hashlist = [None]*10000


    def put(self,key,value):     # putting value in hashmap
        index = self.find_index(key)   # get the index my using  hash fn which is key% length of hashlis
        if self.hashlist[index] == None:
            self.hashlist[index] = self.Node(-1,-1)

        prev_node = self.find_prev_node(self.hashlist[index], key)

        if prev_node.next == None:                    # if next node after previous node is null then create  a new Node
            prev_node.next = self.Node(key, value)
        else:
            prev_node.next.val = value   # else update the of next node with new value


    def get(self,key):
        index = self.find_index(key)

        if self.hashlist[index] == None:  # if index is not present in the hashlist then return -1
            return -1

        prev_node = self.find_prev_node(self.hashlist[index], key)
        # why should we check for this condition again because node.next would never be none if self.Hashlist[i] is not none

        # And the length of our horizontal list is either zero or minimum two nodes right

        return -1 if prev_node.next == None else prev_node.next.val


    def remove(self,key):
        index = self.find_index(key)

        if self.hashlist[index]==None:
            return

        prev_node = self.find_prev_node(self.hashlist[index], key)

        if prev_node.next == None:
            return None

        prev_node.next = prev_node.next.next

    def find_index(self, key):  # to find index for hashList we created  which is key% length of hashlist( HASH FN)
        return hash(key) % len(self.hashlist)

    def find_prev_node(self, head, key):  # head is hashlist[i] in starting and we need to find the previous node then the key we are looking for
        cur = head
        prev = None
        while cur != None and cur.key != key:
            prev = cur
            cur = cur.next
        return prev


if __name__ == "__main__":
	hashMap = MyHashMap()
	hashMap.put(1, 1)
	hashMap.put(2, 2)
	print(hashMap.get(1))
	print(hashMap.get(3))
	print(hashMap.get(2))
	hashMap.put(2, 1)
	print(hashMap.get(2))
	hashMap.remove(2)
	print(hashMap.get(2))
