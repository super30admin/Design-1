
"""
Implement HashSet without using any built-in libraries.

your design should include these functions:

    add(value): Insert a value into the HashSet. 
    contains(value) : Return whether the value exists in the HashSet or not.
    remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:

MyHashSet hashSet = new MyHashSet();

"""


class Bucket:
    def __init__(self):
        self.bucket = []

    def update(self, key):
        found = False
        for i, k in enumerate(self.bucket):
            if key == k:
                self.bucket[i] = key
                found = True
                break
        if not found:
            self.bucket.append(key)

    def get(self, key):
        for k in self.bucket:
            if k == key:
                return True
        return False

    def remove(self, key):
        for i, k in enumerate(self.bucket):
            if key == k:
                del self.bucket[i]


class MyHashSet:
    def __init__(self):
        self.key_space = 2096
        self.hash_table = [Bucket() for i in range(self.key_space)]

    def add(self, key):
        hash_key = key % self.key_space
        self.hash_table[hash_key].update(key)

    def remove(self, key):
        hash_key = key % self.key_space
        self.hash_table[hash_key].remove(key)

    def contains(self, key):
        hash_key = key % self.key_space
        return self.hash_table[hash_key].get(key)


ob = MyHashSet()
ob.add(1)
ob.add(3)
print(ob.contains(1))
print(ob.contains(2))
ob.add(2)
print(ob.contains(2))
ob.remove(2)
print(ob.contains(2))
