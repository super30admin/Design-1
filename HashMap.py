# Time Complexity : Worst Case O(n), expected O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes!
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
class Node(object):

    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

# Implemented HashMap with Chaining, Using an array where every spot in the array in a linked list
class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # n, number of (key, value) pairs in the hashMap
        self.n = 0
        # N, capacity of hashMap, changes with rehash. Initially 5
        self.N = 5
        # alpha is the load factor which changes with put, remove and causes rehash is > alphaMax
        self.alpha = float(self.n) / float(self.N)
        # max load factor of the hashMap
        self.alphaMax = 0.6
        # hashmap init
        self.bucketArray = [None] * self.N

    # rehash creates a bigger hashmap and reinserts all values present into the new map.
    def rehash(self, newSize):
        if newSize > self.N:
            self.n = 0
            self.N = newSize
            oldBucketArray = self.bucketArray
            self.bucketArray = [None] * self.N

            for i in oldBucketArray:
                node = i
                while node != None:
                    self.put(node.key, node.value)
                    node = node.next

    def put(self, key, value):
        # identity hashing function
        lookUpIndex = key % self.N
        # if no list initialised, insert a node with K,V pair
        if self.bucketArray[lookUpIndex] == None:
            toAdd = Node(key, value)
            self.bucketArray[lookUpIndex] = toAdd
            # updating member variables
            self.n += 1
            self.alpha = float(self.n) / float(self.N)
        # else list present, search the list for key, if the key
        # is present update value otherwise prepend (K,V) to list
        else:
            node = self.bucketArray[lookUpIndex]
            while node != None:
                if node.key == key:
                    node.value = value
                    return
                node = node.next

            toAdd = Node(key, value)
            toAdd.next = self.bucketArray[lookUpIndex]
            self.bucketArray[lookUpIndex] = toAdd
            # updating member variables
            self.n += 1
            self.alpha = float(self.n) / float(self.N)
        # if load factor exceeded, trigger rehash.
        if self.alpha > self.alphaMax:
            self.rehash(2 * self.N)

    # if list initialised, search the list and if
    # key present return value otherwise return -1
    def get(self, key):
        retVal = -1
        lookUpIndex = key % self.N

        if self.bucketArray[lookUpIndex] != None:
            node = self.bucketArray[lookUpIndex]
            while node != None:
                if node.key == key:
                    retVal = node.value
                    return retVal
                node = node.next

        return retVal

    def remove(self, key):
        lookUpIndex = key % self.N
        # if list not initialised, that implies (K,V) with given key doesn't exist
        if self.bucketArray[lookUpIndex] == None:
            return
        # else search the list and change links if key present.
        else:
            prev = None
            node = self.bucketArray[lookUpIndex]
            while node != None:
                if node.key == key:
                    if node == self.bucketArray[lookUpIndex]:
                        self.bucketArray[lookUpIndex] = node.next
                    else:
                        prev.next = node.next
                    # updating member variables
                    self.n -= 1
                    self.alpha = float(self.n) / float(self.N)
                    return

                prev = node
                node = node.next

# Your MyHashMap object will be instantiated and called as such:
hashMap = MyHashMap()
hashMap.put(1, 1)
hashMap.put(2, 2)
print hashMap.get(1)
print hashMap.get(3)
hashMap.put(2, 1)
print hashMap.get(2)
hashMap.remove(2)
print hashMap.get(2)
