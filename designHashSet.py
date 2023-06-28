// Time Complexity : Adding - O(N) where N is the number of elements in the hash set, as we are checking if the leement is already present in the list,
// 		Remove - O(N) where N is the number of elements in the hash set, as we are checking if the leement is already present in the list,
//		Contains - O(N) where N is the number of elements in the hash set, as we have to check every element to see if the key is present

// Space Complexity : O(N) as we are using an extra space (List data structure) to store elements

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially did not check for duplicates while adding elements, so the output was incorrect


// Your code here along with comments explaining your approach

class MyHashSet:

    def __init__(self):
        self.hash_set = list()

    def add(self, key: int) -> None:
        if key not in self.hash_set:
            self.hash_set.append(key)

    def remove(self, key: int) -> None:
        if key in self.hash_set:
            position = self.hash_set.index(key)
            self.hash_set.pop(position)

    def contains(self, key: int) -> bool:
        for i in range(len(self.hash_set)):
            if self.hash_set[i] == key:
                return True

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)