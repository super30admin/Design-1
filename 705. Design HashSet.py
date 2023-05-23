# In this code, I created buckets of size 10000. The cal_hash_val function will
# determine the hash of the value by using key%size.
# // Time & Space Complexity : init() : TC = O(1), SC = O(N); cal_hash_val : TC = O(1), SC = O(1); add(): TC = O(1),O(N) in collisions, SC = O(1); remove(): TC = O(N), SC = O(1); Contains(): TC = O(N), SC = O(1);
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
class MyHashSet:

    def __init__(self):
        self.size = 10000
        self.Hashtable = [None]*self.size
    
    def cal_hash_val(self,key):
        return key%self.size   

    def add(self, key: int) -> None:
        hash_value = self.cal_hash_val(key)
        if self.Hashtable[hash_value] is None:
            self.Hashtable[hash_value] = [key]
        else:
            self.Hashtable[hash_value].append(key)


    def remove(self, key: int) -> None:
        hash_value = self.cal_hash_val(key)
        if self.Hashtable[hash_value] != None:
            while (key in self.Hashtable[hash_value]):
                self.Hashtable[hash_value].remove(key)


    def contains(self, key: int) -> bool:
        hash_value = self.cal_hash_val(key)
        if self.Hashtable[hash_value] != None:
            if key in self.Hashtable[hash_value]:
                return True
        return False



# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)