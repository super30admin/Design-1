"""
Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
        void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
        int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
        void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 
 """
# Time Complexity : O(n / k) where n = keys and k = buckets
# Space Complexity : O(n + k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Understood the bucket concept in class but couldnt implement in code but will keep trying



class MyHashMap:

    def __init__(self):
        self.buckets = 10000
        self.s = [None]*self.buckets

    def index(self,key):
        return key%self.buckets

    def find(self,key,node):
        prev = None
        curr = node
        while curr!= None and curr.key!=key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        val = self.index(key)
        if self.s[val]==None:
            self.s[val] = Node(-1,-1)
        prev = self.find(key,self.s[val])
        if prev.next==None:
            prev.next = Node(key,value)
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        val = self.index(key)
        if self.s[val]==None:
            self.s[val] = Node(-1,-1)
        prev = self.find(key,self.s[val])
        if prev.next==None:
            return -1
        else:
            return prev.next.value

    def remove(self, key: int) -> None:
        val = self.index(key)
        if self.s[val]==None:
            self.s[val] = Node(-1,-1)
        prev = self.find(key,self.s[val])
        if prev.next==None:
            return
        else:
            prev.next = prev.next.next


class Node():

    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

s = MyHashMap()
s.put(1, 1)
s.put(2, 2) 
print(s.get(1))
print(s.get(3))
s.put(2, 1)
print(s.get(2))
s.remove(2)
print(s.get(2))
