#executed on leetcode
class MyHashSet:

    def __init__(self):
        self.hashset = []
        
    #used an array named self.hashset
        

    def add(self, key: int) -> None:
        if key not in self.hashset:
            self.hashset.append(key)
    
    # add the key if not exist
            
        

    def remove(self, key: int) -> None:
        if key in self.hashset:
            self.hashset.remove(key)
        else:
            return False
    #remove the key if present in set
        

    def contains(self, key: int) -> bool:
        if key in self.hashset:
            return True
        else:
            return False
        
#Time complexity - O(n) for eaxh function
#space complexity - O(n)


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)