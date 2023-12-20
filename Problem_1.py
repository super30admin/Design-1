# Time Complexity : O(K) where k represents the time for any bucket with largest amount of collisions otherwise assuming there are no collisions this would be O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No but would have been helpful to have a function pre defined for implementing the hash function
# This hashset implementation is utilizing seperate chaining where each bucket in the hashset is a dynamic list that can store multiple elements, in any of our operations 
# we calculate the the bucket index first and then once this is determined we can execute the operation on the list in that given bucket



class MyHashSet:

    def __init__(self):
        self.size = 500
        self.buckets = [[] for x in range(self.size)] # creating a seperate list for each possible hash value
    
    def hash_val(self,key):
        return key % self.size # seeting our hash function

    def add(self, key: int) -> None:
        index_of_bucket = self.hash_val(key) # generating hash value for the given key
        if key not in self.buckets[index_of_bucket]: # if key does not exsist append it to the list at the bucket index
            self.buckets[index_of_bucket].append(key) # if a collision occurs both values will be in the same bucket but will be 2 different distinct elements in our list

    def remove(self, key: int) -> None:
        index_of_bucket = self.hash_val(key)
        if key in self.buckets[index_of_bucket]: # generating hash value and then searching within that bucket location to see if the key exsists
            self.buckets[index_of_bucket].remove(key) # removes the key from the specified bucket

    def contains(self, key: int) -> bool:
        index_of_bucket = self.hash_val(key)
        return key in self.buckets[index_of_bucket] # generating hash value and then searching within that bucket location to see if the key exsists


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)