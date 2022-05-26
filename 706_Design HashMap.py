"""
Leetcpde - https://leetcode.com/problems/design-hashmap/
# TC - O(1), O(sqrt(n))
# Challenge - considering edge case of 10^6.

Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.


Example 1:

Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]


Constraints:

0 <= key, value <= 10^6
At most 10^4 calls will be made to put, get, and remove.
"""

'''
Idea- Use double hash map to reduce space by sqrt(n) average space complexity
'''


class MyHashMap:
    # SC - O(sqrt(N))
    def __init__(self):
        self.parentArrayLength = 1000
        self.childArrayLength = 1000
        self.parentArray = [None] * self.parentArrayLength

    # TC - O(1) - not considering array initialization
    def put(self, key: int, value: int) -> None:
        hashVal1 = self.hashFunc1(key)
        hashVal2 = self.hashFunc2(key)

        # only make the child array when needed
        if not self.parentArray[hashVal1]:
            # handling edge case where we will need extra length in child array
            if hashVal2 == self.childArrayLength:
                self.parentArray[hashVal1] = [-1] * (self.childArrayLength + 1)
            else:
                self.parentArray[hashVal1] = [-1] * self.childArrayLength

        self.parentArray[hashVal1][hashVal2] = value

    # TC - O(1)
    def get(self, key: int) -> int:
        hashVal1 = self.hashFunc1(key)
        hashVal2 = self.hashFunc2(key)
        if self.parentArray[hashVal1] and self.parentArray[hashVal1][hashVal2] > -1:
            return self.parentArray[hashVal1][hashVal2]
        return -1

    # TC - O(1)
    def remove(self, key: int) -> None:
        hashVal1 = self.hashFunc1(key)
        hashVal2 = self.hashFunc2(key)
        if self.parentArray[hashVal1] and self.parentArray[hashVal1][hashVal2] > -1:
            self.parentArray[hashVal1][hashVal2] = -1

    # TC - O(1)
    # parent hash function
    def hashFunc1(self, x):
        return x % self.parentArrayLength

    # TC - O(1)
    # child hash function
    def hashFunc2(self, x):
        return x // self.childArrayLength


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(1000000, 1)
# obj.put(11, 0)
# obj.put(1011, 1)
# obj.put(0, 2)
# obj.put(2, 1)
# print(obj.get(11))
# print(obj.get(0))
# obj.remove(11)
# obj.remove(1011)
# print(obj.parentArray)
