# Time Complexity : O(1)
# Space Complexity : O(k * k). Here K = 1000
# Did this code successfully run on Leetcode : Tested locally.
# Any problem you faced while coding this : No

class MyHashSet:

    def __init__(self):
        self.hash_set = [None] * 1000
        

    def add(self, key: int) -> None:
        first_key = key % 1000
        second_key = key // 1000
        if self.hash_set[first_key] == None:
            self.hash_set[first_key] = [None] * 1001
        self.hash_set[first_key][second_key] = key
        

    def remove(self, key: int) -> None:
        first_key = key % 1000
        second_key = key // 1000
        if self.hash_set[first_key] != None:
            if self.hash_set[first_key][second_key] == key:
                self.hash_set[first_key][second_key] = None
        

    def contains(self, key: int) -> bool:
        first_key = key % 1000
        second_key = key // 1000
        if self.hash_set[first_key] != None:
            if(self.hash_set[first_key][second_key] == key):
                return True
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
