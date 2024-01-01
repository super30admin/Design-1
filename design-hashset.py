# Time complexity: O(n/k) where n is the number of elements and k is size of the list which is 1000
# Space Complexity: O(N)
# Did this code successfully run on Leetcode : yes
# class MyHashSet:

#     def __init__(self):
#         self.storage = [[] for index in range(1000)]

#     def add(self, key: int) -> None:
#         hash = key % 1000
#         if not self.contains(key):
#             self.storage[hash].append(key)

#     def remove(self, key: int) -> None:
#         hash = key % 1000
#         if self.contains(key):
#             self.storage[hash].remove(key)

#     def contains(self, key: int) -> bool:
#         hash = key % 1000
#         return key in self.storage[hash]

class MyHashSet:

    def __init__(self) -> None:
        self.storage = [[] for index in range(1000)]

    def add(self, key:int):
        hash = key % 1000
        if not self.contains(key):
            self.storage[hash].append(key)
    
    def remove(self, key:int):
        hash = key%1000
        if self.contains(key):
            self.storage[hash].remove(key)

    def contains(self,key:int) -> bool:
        hash = key%1000
        return key in self.storage[hash]
            