# Submitted in leetcode
# Time complexity : O(1)
# Space Complexity : O(n/2)



class MyHashSet:
#     Create a empty hashset and define hash

    def __init__(self):
        self.hashset = [None] *10000
        hash = 0

#     calculate hash 
# if hash index in None create a new array
# else apppend the array at the hash index in hashset

    def add(self, key: int) -> None:
        hash = key % len(self.hashset)
        if self.hashset[hash] == None:
            self.hashset[hash] = [key]
        else:
            self.hashset[hash].append(key)
        return None

    
#     calculate hash 
# when Hashset is not empty
# remove all the occurance of key from the arrray using while loop

    def remove(self, key: int) -> None:
        hash = key % len(self.hashset)
        if self.hashset[hash] != None:
            while key in self.hashset[hash]:
                self.hashset[hash].remove(key)
        return None
    
    
#     calculate hash 
# when the hashset hols an array find the presence of key in the hash index in the array. 
    def contains(self, key: int) -> bool:
        hash = key % len(self.hashset)
        if self.hashset[hash] != None:
            return key in self.hashset[hash]
        
        return None

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)