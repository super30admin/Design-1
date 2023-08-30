# Time Complexity - O(1)
# Space Complexity - O(N) where N is the number of elements to be stored

# Approach - Double hashing is used. Using boolean datatype to reduce extra space.

class MyHashSet:

    def __init__(self):
        self.hash_set = [None] * 1000
        
    def add(self, key: int) -> None:
        # Both keys are computed
        first_key = key % 1000
        second_key = key // 1000
        # Array for the first key is not initialized
        if self.hash_set[first_key] == None:
            self.hash_set[first_key] = [None] * 1001
        self.hash_set[first_key][second_key] = True
        

    def remove(self, key: int) -> None:
        first_key = key % 1000
        second_key = key // 1000
        if self.hash_set[first_key] != None:
            if self.hash_set[first_key][second_key] == True:
                self.hash_set[first_key][second_key] = False
        

    def contains(self, key: int) -> bool:
        first_key = key % 1000
        second_key = key // 1000
        if self.hash_set[first_key] != None:
            if(self.hash_set[first_key][second_key] == True):
                return self.hash_set[first_key][second_key]
        return self.hash_set[first_key][second_key]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)