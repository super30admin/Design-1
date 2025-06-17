# // Time Complexity : O(1)
# // Space Complexity : O(1)
    
# We use empty array for 10^6 + 1 (for indexes) since these are limit to our inputs.
# We will use the array as hashing table where keys will be stored at same index as their values, giving use O(1) retrieval.

class MyHashSet:

    def __init__(self):
        self.hashset = ["" for i in range(1000001)]
        
    
    def add(self, key: int) -> None:
        
        if(self.hashset[key] == ""):
            self.hashset[key] = key

    def remove(self, key: int) -> None:
        self.hashset[key] = ""

    def contains(self, key: int) -> bool:
        if(self.hashset[key] == key): 
            return True
        return False

    

        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)