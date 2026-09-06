"""
# Time Complexity: O(1) for each operation - add, remove, and contains.
# Space Complexity: O(n) where n is the number of unique keys stored.

// Did this code successfully run on Leetcode : Yes - 705. Design HashSet


Approach: We are utilizing Double Hashing technique to implement the HashSet. 
We are using two hash functions to get the primary and secondary bucket index.
The primary bucket index is calculated using modulo operation and the secondary bucket index is calculated using integer division.
We are using a list of lists to store the values in the HashSet. 
The primary list has a size of 1000 and each secondary list has a size of 1000.
The first primary bucket (index 0) has a size of 1001 to accommodate the maximum value of 10^6.

"""





class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.primary_buckets = 1000
        self.secondary_buckets = 1000
        self.total_storage = [None] * self.primary_buckets
    
    def get_primary_bucket_index_hash(self, key:int) -> int:
        return key % self.primary_buckets
    
    def get_secondary_bucket_index_hash(self, key:int) -> int:
        return key // self.secondary_buckets 
    
    def add(self, key: int) -> None:
        primary_bucket_index = self.get_primary_bucket_index_hash(key)
        if self.total_storage[primary_bucket_index] is None:
            if primary_bucket_index == 0:
                self.total_storage[primary_bucket_index] = [False for i in range(self.secondary_buckets + 1)]
            else:
                self.total_storage[primary_bucket_index] = [False for i in range(self.secondary_buckets)]
        secondary_bucket_index = self.get_secondary_bucket_index_hash(key)
        self.total_storage[primary_bucket_index][secondary_bucket_index] = True

    def remove(self, key: int) -> None:
        primary_bucket_index = self.get_primary_bucket_index_hash(key)
        if self.total_storage[primary_bucket_index] is None:
            return
        secondary_bucket_index = self.get_secondary_bucket_index_hash(key)
        self.total_storage[primary_bucket_index][secondary_bucket_index] = False
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        primary_bucket_index = self.get_primary_bucket_index_hash(key)   
        if self.total_storage[primary_bucket_index] is None:
            return False
        secondary_bucket_index = self.get_secondary_bucket_index_hash(key)
        return self.total_storage[primary_bucket_index][secondary_bucket_index]
        
 
def run_tests():
    hs = MyHashSet()
    assert hs.contains(1) == False
 
    hs.add(1)
    assert hs.contains(1) == True
    assert hs.contains(2) == False
 
    hs.add(2)
    hs.remove(2)
    assert hs.contains(2) == False
 
    hs.remove(5)  # never-touched bucket, should not raise
    assert hs.contains(5) == False
 
    hs.add(1)  # duplicate add
    assert hs.contains(1) == True
 
    hs.add(0)
    assert hs.contains(0) == True
    hs.remove(0)
    assert hs.contains(0) == False
 
    hs.add(5)
    hs.add(1005)  # same primary bucket as 5, different secondary
    assert hs.contains(5) == True
    assert hs.contains(1005) == True
    hs.remove(5)
    assert hs.contains(5) == False
    assert hs.contains(1005) == True
 
    key = 10 ** 6  # boundary edge case: primary=0, secondary=1000
    hs.add(key)
    assert hs.contains(key) == True
    hs.remove(key)
    assert hs.contains(key) == False
 
    print("All assertions passed!")
 

if __name__ == "__main__":
    run_tests()