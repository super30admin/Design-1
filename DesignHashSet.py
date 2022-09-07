"""
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:
void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

Constraints:
0 <= key <= 106
At most 104 calls will be made to add, remove, and contains.

Approach --
1. Initialize a primary array. Set all elements to null. Set the size of the primary array as the square root of the
given range.
2. Use a mod function has the first hashing function inorder to determine which index to add the element to
3. Once the index is found, initialize secondary array as a boolean array of same size as primary array for that index
4. Inorder to avoid collision, a secondary hash function can be used by dividing the element by range of secondary array
5. Once the index is found add it to found position in the secondary array
6. Continue till the last element

Time Complexity - Because it is constant time for add, remove, search, contains - the time complexity is O(1)
Space Complexity - is O(n)
"""
class SHashSet:
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = [None] * self.buckets

    # First hashing function
    def getBucket(self, key):
        return key % self.buckets

    # Second hashing function
    def getBucketItems(self, key):
        return key // self.buckets

    def add(self, key):
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key)

        # edge case
        if not self.bucketItems[bucket] and bucket == 0:
            self.bucketItems[bucket] = [False] * (self.buckets+1)

        # if there are no items in the bucket, secondary array will not initialized
        # initialize secondary array once the index for primary has been found as null
        elif not self.bucketItems[bucket]:
            self.bucketItems[bucket] = [False] * self.buckets

        # add element
        self.bucketItems[bucket][bucketItem] = True

    def remove(self, key):
        # check if the element exists at the index
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key)

        # mark the item as false if found
        if self.bucketItems[bucket]:
            self.bucketItems[bucket][bucketItem] = False

    def contains(self, key):
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key)

        # if the item is present
        if self.bucketItems[bucket]:
            return self.bucketItems[bucket][bucketItem]

# Your MyHashSet object will be instantiated and called as such:
# myhashset = SHashSet()
# myhashset.add(8)
# myhashset.add(3)
# myhashset.add(33)
# myhashset.add(3)
# myhashset.remove(15)
# print(myhashset.contains(8))
