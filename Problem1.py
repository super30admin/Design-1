# Time Complexity : O(n/k) where n is the total number of elements possible (which is 10^6) and k is the fixed size of the array (which I gave as 1000) here. 
# My implementation will run in 10^6/10^3 i.e 10^3 or O(1000) time. Larger k will run quicker and will also take more space.
# Space Complexity : O(n) Since we have an array of size 1000 which contains arrays inside them and the total space is capable of holding the n possible elements.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

################### NOT EFFIFCIENT, CHeck leetcode submission for optimal O(1) with double hashing ################################################

# Your code here along with comments explaining your approach

class MyHashSet:

    def __init__(self):
        self.size = 1000 # Size is set to 1000. Each time we check key%1000 and add key to that particular index
        self.hashSet = [[] for i in range(self.size)] # Initializing hashSet 

    def add(self, key: int) -> None:
        if not self.contains(key): # Check if key exists already and add key if it is not there
            self.hashSet[key%self.size].append(key) # Add key by going to the key%size index in the hashSet

    def remove(self, key: int) -> None:
        if self.contains(key): # Check if the key exists, we can not remove a key that is not already there 
            self.hashSet[key%self.size].remove(key) # Remove key by going to the key%size index in the hashSet
        

    def contains(self, key: int) -> bool:
        if key in self.hashSet[key%self.size]: # Return 1 (true) if the key is in the key%size index in hashSet
            return 1
        else: 
            return 0 # If not return 0 (false)
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)