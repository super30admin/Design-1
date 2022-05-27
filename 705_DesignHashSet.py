'''
Leetcode - https://leetcode.com/problems/design-hashset/
Company - Paypal
TC - O(N), SC - O(N)
Topic - Array, Hashmap

Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:
void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.


Example 1:

Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)


Constraints:

0 <= key <= 10^6
At most 104 calls will be made to add, remove, and contains.
'''


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

class MyHashSet:
    # TC: O(N) - initializing array, SC: O(N)
    def __init__(self):
        # possible keys (refer constraints) - remember index start from 0 and index should go <=10^6
        self.arr = [-1] * ((10 ** 6) + 1)

    # TC: O(1) SC: O(1)
    def add(self, key: int) -> None:
        self.arr[key] = key

    # TC: O(1) SC: O(1)
    def remove(self, key: int) -> None:
        self.arr[key] = -1

    # TC: O(1) SC: O(1)
    def contains(self, key: int) -> bool:
        return self.arr[key] >= 0

obj = MyHashSet()
obj.add(0)
obj.add(99999)
print(obj)
