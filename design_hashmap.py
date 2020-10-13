# Time Complexity : O(n/c):- n=No. of elements, c=No. of slots avilable, 997
# put:- average case:- O(1)/worst case:- O(n)
# get:- average case:- O(1)/worst case:- O(n)
# remove:- average case:- O(1)/worst case:- O(n)
# Space Complexity :O(c):- c=No. of slots available
# Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : I wanted to implement Double Hashing, but couldn't figure out a 
# way to find out what would be the best second hash function we should use for resolving collisions. Maybe a different prime number.
# Idea:- Fix the number of slots you can map a key to, played around with lot of prime numbers fixed the prime number 
# to be less than 1000 considering the input we have, to resolve collisions naively used an array
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.my_hashmap=[-1]*997
        
    def evaluate_hash(self,key):
        return key%997
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hash=self.evaluate_hash(key)
        if self.my_hashmap[hash]==-1:
            self.my_hashmap[hash]=[[key,value]]
        else:
            for i in range(len(self.my_hashmap[hash])):
                if self.my_hashmap[hash][i][0]==key:
                    self.my_hashmap[hash][i][1]=value
                    return 
            self.my_hashmap[hash].append([key,value])
        
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hash=self.evaluate_hash(key)
        if self.my_hashmap[hash]!=-1:
            for i,j in self.my_hashmap[hash]:
                if i==key:
                    return j
        return -1
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hash=self.evaluate_hash(key)
        if self.my_hashmap[hash]!=-1:
            for i in range(len(self.my_hashmap[hash])):
                if self.my_hashmap[hash][i][0]==key:
                    self.my_hashmap[hash].pop(i)
                    return
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)