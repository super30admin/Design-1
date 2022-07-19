# Time Complexity : O(1)
# Space Complexity : O(n)

class MyHashSet:

    # declaring the default values for the matrix to store the values
    def __init__(self):
        self.buckets = 1000
        self.bucket_items = 1000
        self.storage = [False for i in range(self.buckets)]
    
    # Defining the hash function1 as the mod operation which is done by the length of the buckets array
    def hash1(self, key):
        return int(key%self.buckets)
    # Defining the hash function2 as the div operation which is done by the length of the bucketItem array
    def hash2(self, key):
        return int(key/self.bucket_items)
    
    # In order to add a value, we need to check, if there previously have a value, so that we can check if there is a nested array
    # If it is not present, then we ourselves create a boolean array, and assign it values. For 0 index, we create an array of 1001 as we need
    # to store the value 0 and 1000000 in this array, for other array's we use the value 1000 for length
    # finally store the value in the array using the value obtained from both hash values
    def add(self, key: int) -> None:
        hash_val1 = self.hash1(key)
        hash_val2 = self.hash2(key)
        
        if self.storage[hash_val1] == False:
            if hash_val1 == 0:
                self.storage[hash_val1] = [False for j in range(self.buckets+1)]
            else:
                self.storage[hash_val1] = [False for j in range(self.buckets)]
            
        self.storage[hash_val1][hash_val2] = True

    # In order to remove an element, we need to check if it is present in the array. This can be used by checking the value using both hash function values
    # As there can only be one position for any value, if the hashed value location is False, then the value is not present, hence cannot be removed
    def remove(self, key: int) -> None:
        hash_val1 = self.hash1(key)
        hash_val2 = self.hash2(key)
        
        if self.storage[hash_val1] == False:
            return
        self.storage[hash_val1][hash_val2] = False

    # This is to check if the array contains the values or not, for this we can check first in the primary array, if there is a nested array, then return 
    # whatever value is present in the secondary array as the array type is boolean which is required output
    def contains(self, key: int) -> bool:
        hash_val1 = self.hash1(key)
        hash_val2 = self.hash2(key)
        
        if self.storage[hash_val1] == False:
            return False
        return self.storage[hash_val1][hash_val2]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
