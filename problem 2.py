# Implement HashMap
'''
Leetcode all test cases passed: Yes
MyHashMap:
    Space Complexity: O(n)
    put(self, key,value):
        Time Complexity: O(1)
    get(self, key):
        Time Complexity: O(1)
    remove(self, key):    
        Time Complexity: O(1)
'''


class MyHashMap:

    def __init__(self):
        self.hashMap = [-1] * 1000
        self.hash1 = 1000

    def put(self, key: int, value: int) -> None:
        pointer = key % self.hash1
        if self.hashMap[pointer] == -1 and pointer == 0:
            self.hashMap[pointer] = [-1] * 1001
        elif self.hashMap[pointer] == -1:
            self.hashMap[pointer] = [-1] * 1000
        self.hashMap[pointer][key // self.hash1] = value

    def get(self, key: int) -> int:
        if self.hashMap[key % self.hash1] == -1:
            return -1
        return self.hashMap[key % self.hash1][key // self.hash1]

    def remove(self, key: int) -> None:
        if self.hashMap[key % self.hash1] == -1:
            return -1
        self.hashMap[key % self.hash1][key // self.hash1] = -1
