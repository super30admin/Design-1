'''
Time Complexity : O(1)

Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes

Any problem you faced while coding this : Using 2D Array's in Python was very difficult
especially using Booleans, I had to use None to populate the main Hashtable as python does
not contain Null and use None in the inside HashMap for edge case -> if the element is 0.
In addition to this we cannot check a[outerIndex][innerIndex] so I had to check if the
a[outerIndex] is a list then perform further checks. So it was quite time consuming!

Solution: Create 2 lists which will form the base of the hashmap, use 2 hashing functions
-> bucketHash and bucketItemhash to compute the hash for a particular key.
For put check if bucketHash exists if not create a new array inside the bucketHash index in
the main array.
For remove set the value to None if the element does not exits.
'''


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None for x in range(0, self.buckets)]

    def bucketHash(self, key: int) -> int:
        return key % self.buckets

    def bucketItemsHash(self, key: int) -> int:
        return int(key / self.bucketItems)

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        bucketKey = self.bucketHash(key)
        bucketItem = self.bucketItemsHash(key)

        if self.storage[bucketKey] == None:
            self.storage[bucketKey] = ([None for x in range(0, self.bucketItems)])

        self.storage[bucketKey][bucketItem] = value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """

        bucketKey = self.bucketHash(key)
        bucketItem = self.bucketItemsHash(key)

        # need to write it this way for python
        if type(self.storage[bucketKey]) is list:
            if self.storage[bucketKey][bucketItem] is not None:
                return self.storage[bucketKey][bucketItem]
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        bucketKey = self.bucketHash(key)
        bucketItem = self.bucketItemsHash(key)

        # way to check if key is list is not present and
        # hence out of bounds in python
        if type(self.storage[bucketKey]) is list:
            if self.storage[bucketKey][bucketItem]:
                self.storage[bucketKey][bucketItem] = None

# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1,2)
obj.put(8,10)
obj.put(20,0)
print("key is: " + str(obj.get(8)))
obj.remove(20)
