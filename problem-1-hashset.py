## Problem 1:(https://leetcode.com/problems/design-hashset/)

# Created a two datastructures first referenceing to another. To place the key in the ds used % and // to find it's position in two different methods and used those methods while adding and removing the keys and checking whether it exists or not. Time complexity O(1)


class MyHashSet:
    def __init__(self):
        # initialize the buckets
        self.primary_buckets = 1000
        self.secondary_buckets = 1000
        # initially all primary buckets are set to None
        self.storage = [None] * self.primary_buckets

    # method to define position of key in first datastructure
    def get_primary_hash(self, key):
        return key % self.primary_buckets

    # method to reference the secondary position inside the second datastructure
    def get_secondary_hash(self, key):
        return key // self.secondary_buckets

    # method to insert the value into the hashset
    def add(self, key):
        # primary_index acts like x coordinate to add the key in primary storage
        primary_index = self.get_primary_hash(key)
        # to check if the primary storage is none for the given key and if it is then intialise the secondary bucket
        if self.storage[primary_index] is None:
            # this condition is to handle the special case at index 0
            if primary_index == 0:
                self.storage[primary_index] = [False] * (self.secondary_buckets + 1)
            # for rest of the indexes follow n * n matrix
            else:
                self.storage[primary_index] = [False] * self.secondary_buckets
        # secondary_index acts like a y coordinate, if the primary storage is already exist then add the key into secodary storage
        secondary_index = self.get_secondary_hash(key)
        # using x and y coordinate store the key by flaggin True
        self.storage[primary_index][secondary_index] = True

    # method to remove the value from hashset
    def remove(self, key):
        # index to find the key in primary bucket
        primary_index = self.get_primary_hash(key)
        # to check if the primary bucket exists if not then nothing to remove
        if self.storage[primary_index] is None:
            return
        # find the key in the secondary bucket
        secondary_index = self.get_secondary_hash(key)
        # mark it to false
        self.storage[primary_index][secondary_index] = False
    
    # method to check whether the key is exist in hashset or not
    def contains(self, key):
        # index to find the key in primary bucket
        primary_index = self.get_primary_hash(key)
        # to check if the primary bucket exists if not then key is not exist
        if self.storage[primary_index] is None:
            return False
        # find the key in the secondary bucket
        secondary_index = self.get_secondary_hash(key)
        # return bool value stored
        return self.storage[primary_index][secondary_index]


# In the class Instructor showed the optimal approach. Completed below exercise before the class with O(n) approach

# Created a attribute in form of `list` that stores the keys.
# Add - Use class's own `contains` and `remove` methods, to remove any existing key. Used the list's append method to add keys. O(n)
# Remove - Using del statement and iteration to remove (instead of using list's `remove` method). O(n)
# Contains - iterate and match to return if found. O(n)

class MyHashSet:
    # method to intialize the hashset
    def __init__(self):
        self.hashset = []

    # method to insert the value into the hashset
    def add(self, key: int) -> None:
        # check the given values in the hashset
        if self.contains(key):
            # if present remove the value
            self.remove(key)
        # append the value in either cases
        self.hashset.append(key)

    # method to remove the value from the hashset    
    def remove(self, key: int) -> None:
        # iterate over the hashset
        for i, element in enumerate(self.hashset):
            # match the element with the given value
            if element == key:
                # remove the key if it matches
                    del self.hashset[i:i+1]
    
    # method to check whether the key is exist in hashset or not
    def contains(self, key: int) -> bool:
        # iterate over the hashset
        for i in self.hashset:
            # match the key with the value
            if i == key:
                return True
        return False



# myHashSet = MyHashSet()
# print(myHashSet.add(1))      # set = [1]
# print(myHashSet.add(2))      # set = [1, 2]
# print(myHashSet.contains(1)) # return True
# print(myHashSet.contains(3)) # return False, (not found)
# # print(myHashSet.hashset)
# print(myHashSet.add(2))      # set = [1, 2]
# print(myHashSet.contains(2)) # return True
# print(myHashSet.remove(2))
# # print(myHashSet.hashset)   # set = [1]
# print(myHashSet.contains(2)) # return False, (already removed)
# # print(myHashSet.hashset)