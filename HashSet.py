"""
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
"""


class HashSet:

    def __init__(self):
        self.size = 1000
        self.table = [None] * self.size

    def hash(self, key):
        return key % self.size

    def add(self, key):
        hash_key = self.hash(key)
        if self.table[hash_key] is None:
            self.table[hash_key] = [key]
        else:
            self.table[hash_key].append(key)

    def contains(self, key):
        hash_key = self.hash(key)
        if self.table[hash_key] is None:
            return False
        else:
            return key in self.table[hash_key]

    def remove(self, key):
        hash_key = self.hash(key)

        if self.table[hash_key]:
            while key in self.table[hash_key]:
                self.table[hash_key].remove(key)
