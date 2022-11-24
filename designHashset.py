#Time Complexity : O(1) for add, remove, contains
#Space Complexity : O(n) worst case if we just do add operation and store only the elements on to the dictionary
#Did this code successfully run on Leetcode : Yes it ran successfully
#Any problem you faced while coding this : No issues faced


#Your code here along with comments explaining your approach
import collections
class MyHashSet:

    def __init__(self):
        self.hashmap = {}                           #creating a dictionary named hashmap

    def add(self, key: int) -> None:
        self.hashmap[key] = 1                       #we add the key to the dictionary and set value to 1

    def remove(self, key: int) -> None:
        self.hashmap[key] = 0                       #to remove we just reset the value to 0

    def contains(self, key: int) -> bool:
        return self.hashmap.get(key)                #using the dictionary inbuilt get method we get the correct key in O(1) time


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)