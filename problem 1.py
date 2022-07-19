# Implement HashSet
'''
Leetcode all test cases passed: Yes
MyHashSet:
    Space Complexity: O(n)
    add(self, key):
        Time Complexity: O(1)
    remove(self, key):
        Time Complexity: O(1)
    contain(self, key):    
        Time Complexity: O(1)
'''


class MyHashSet:

    def __init__(self):
        self.hashSet = [None] * 1000
        self.hash1 = 1000

    def add(self, key: int) -> None:
        pointer = key % self.hash1
        if self.hashSet[pointer] == None and pointer == 0:
            self.hashSet[pointer] = [False] * 1001
        elif self.hashSet[pointer] == None:
            self.hashSet[pointer] = [False] * 1000
        self.hashSet[pointer][key // self.hash1] = True

    def remove(self, key: int) -> None:
        if self.hashSet[key % self.hash1] == None:
            return None
        self.hashSet[key % self.hash1][key // self.hash1] = False

    def contains(self, key: int) -> bool:
        if self.hashSet[key % self.hash1] == None:
            return None
        return self.hashSet[key % self.hash1][key // self.hash1]
