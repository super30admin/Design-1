# Time Complexity - O(1) for all the defined
# Space Complexity - O(1) for the all the functions defined
# Note to self - In the add function, a new list is created that is part of the data structure 
# not some extra auxiliary space used by the function. So, its not considered as extra consumption
# Approach - Used double hashing to store the values in the array

class MyHashSet:

    def __init__(self):
        # 1000 * 1000 will give the max range that was mentioned
        # in the problem. So, square root of 10^6 = 1000
        self.buckets = 1000
        self.inner_buckets = 1000
        self.arr = [None for i in range(self.buckets)]

    # A unique hash function to calculate the placement of value in the array
    def get_outer_hash(self, value:int)->int:
        return value % self.buckets
        
    # A unique hash function to calculate the placement of value in the inner array
    def get_inner_hash(self, value:int)->int:
        return value // self.inner_buckets

    def add(self, key: int) -> None:
        outer_hash = self.get_outer_hash(key)
        inner_hash = self.get_inner_hash(key)

        if self.arr[outer_hash] == None:
            if outer_hash == 0: # Need to handle one extra number as the range is included
                self.arr[outer_hash] = [None] * (self.inner_buckets+1)
            else:
                self.arr[outer_hash] = [None] * (self.inner_buckets)

        self.arr[outer_hash][inner_hash] = True


    def remove(self, key: int) -> None:
        outer_hash = self.get_outer_hash(key)
        inner_hash = self.get_inner_hash(key)
        if self.arr[outer_hash] == None:
            return
        self.arr[outer_hash][inner_hash] = False

    def contains(self, key: int) -> bool:
        outer_hash = self.get_outer_hash(key)
        inner_hash = self.get_inner_hash(key)
        if self.arr[outer_hash] == None:
            return False
        return self.arr[outer_hash][inner_hash]
        
# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)