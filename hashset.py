 # Time Complexity : O(1) for all functions
 # Space Complexity : O(n)
 # Did this code successfully run on Leetcode : Yes
 # Any problem you faced while coding this : None

class MyHashSet:

    # initialising the size of the empty bucket as 1000(square root of 10**6)
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 1000
        self.bucket = [None] * self.size

    # Function to return the bucket hash value
    def get_bucket_hash(self, key):
        return key % self.size

    # Function to add the element to the bucket
    def add(self, key: int) -> None:
        bucket_index = self.get_bucket_hash(key)

        if self.bucket[bucket_index] == None:
            self.bucket[bucket_index] = [key]
        else:
            self.bucket[bucket_index].append(key)

    # Function to remove the element from the hashset
    def remove(self, key: int) -> None:
        bucket_index = self.get_bucket_hash(key)

        if self.bucket[bucket_index] != None:
            while key in self.bucket[bucket_index]:
                self.bucket[bucket_index].remove(key)

    # Function to check if the element exists in the hashset
    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        bucket_index = self.get_bucket_hash(key)

        if self.bucket[bucket_index] != None:
            return key in self.bucket[bucket_index]
        return False

    def print_hashset(self):
        return self.bucket
# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(5)
obj.add(7)
obj.add(8)
obj.add(9)
#obj.remove(key)
#param_3 = obj.contains(key)
print(obj.print_hashset())
