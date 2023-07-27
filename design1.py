# Time Complexity : O(1) for all operations.
# Space Complexity : O(N) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Initially I used chaining approach which I used for designing the hashmap but the double hashing approach taught
# by Raj sir was very helpful and easy to implement.


# Your code here along with comments explaining your approach
# Design HashSet using arrays and double hashing
# To avoid collision, we use another array to store the elements where a collision occurs and use another hash function to calculate the index of the second array.
# We initialize two arrays - both of size 1000 and 1000 as we are given the range of the elements to be 10^6, we square root it and take the ceiling value to get the size of the array.
# For add operation, we get the hash keys for both the arrays and if the primary array is empty, we create a new array to store the elements and set that value to true.
# For remove operation, we get the hash keys for both the arrays and if the primary array is empty, we can return early otherwise we set the corresponding element to false.
# For contains operation, we get the hash keys for both the arrays and if the primary array is empty, we return False otherwise we check the corresponding element in the array and return True if it is present.

class MyHashSet:

    def __init__(self) -> None:
        self.bucket = 1000 # Primary Bucket
        self.bucketItems = 1000  # Secondary Bucket
        self.storage = [None] * self.bucket # Storage array

    # First hash function - Mod operation

    def hash_one(self, key):
        return key % self.bucket
    
    # Second hash function - Integer Division Operation

    def hash_two(self, key):
        return key // self.bucketItems
    

    # Add operation

    def add(self, key):
        bucket_key = self.hash_one(key)
        bucketItem_key = self.hash_two(key)

        # If primary array is empty, we will create a new array to store the elements and set that corresponding hashed index of the new array to True

        if self.storage[bucket_key] == None:
            # Edge Case - If the key is 10^6 than it will lead to an out of bounds error so need to check it as it will only happen in the secondary array situated in the 0th index of the primary array
            if bucket_key == 0:
                self.storage[bucket_key] = [None] * (self.bucketItems + 1) # Adding one as the secondary index will go out of bounds by one element

            else:
                self.storage[bucket_key] = [None] * self.bucketItems

            # setting the value to true
            self.storage[bucket_key][bucketItem_key] = True


    def remove(self, key):
        bucket_key = self.hash_one(key)
        bucketItem_key = self.hash_two(key)

        # If the primary key is empty, we return false early or else we set the corresponding index to False

        if self.storage[bucket_key] == None:
            return
        
        # Setting it to false if we do find the key
        self.storage[bucket_key][bucketItem_key] = False


    def contains(self, key):
        bucket_key = self.hash_one(key)
        bucketItem_key = self.hash_two(key)


        # If the primary key is empty, we return false early, if not we check if the value is true at the corresponding index and return the boolean result

        if self.storage[bucket_key] == None:
            return False
        
        return self.storage[bucket_key][bucketItem_key] == True

