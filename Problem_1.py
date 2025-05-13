# Time Complexity - O(n) for initializing the array and O(1) for add, remove, contains function
# Space Complexity - O(n) for the self.hashset space
# Approach - I have created an array with a size of (10**6) each value assigned as '-1'.
# I am using a simple hash function which uses modulo operator which hashes the key and added the key to hash output
# When I add a key in the array i change the value from -1 to the key and when I remove the key I reassign the value as -1
# This code was successfully run on Leetcode

class Hashset:
    def __init__(self, capacity):
        self.hashset = [-1] * capacity
        self.cap = capacity
    
    def hashfunc(self, key):
        return key % self.cap

    def add(self, key: int):
        hashval = self.hashfunc(key)
        if self.hashset[hashval] == -1:
            self.hashset[hashval] = key
            return True
        return False
    
    def remove(self, key: int):
        hashval = self.hashfunc(key)
        if self.hashset[hashval] != -1:
            self.hashset[hashval] = -1
            return True
        return False

    def contains(self, key: int):
        hashval = self.hashfunc(key)
        if self.hashset[hashval] == -1:
            return False
        return True

capacity = (10**6)-1
hashset = Hashset(capacity)
print(hashset.add(10))
print(hashset.add(11))
print(hashset.add(12))
print(hashset.add(13))
print(hashset.add(14))
print(hashset.add(15))
print(hashset.contains(15))
print(hashset.remove(15))
print(hashset.contains(15))
print(hashset.remove(15))