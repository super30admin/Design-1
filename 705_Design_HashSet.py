'''
## Problem 1:(https://leetcode.com/problems/design-hashset/)

## Author: Neha Doiphode
## Date  : 06-21-2022

## Title:
    Design a HashSet without using any built-in hash table libraries.

## Description:
    Implement MyHashSet class:
    void add(key) Inserts the value key into the HashSet.
    bool contains(key) Returns whether the value key exists in the HashSet or not.
    void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.



## Example 1:
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

## Constraints:
        0 <= key <= 106
        At most 104 calls will be made to add, remove, and contains.

## Time complexity:
    O(n/k), where n is number of possible values to be added in the hashset.
                  k is number of pre-defined buckets.

            In worst case we might have to traverse, all buckets and all elements present in the bucket.

## Space complexity:
   O(n + k), where n is number pre-defined buckets
                   k is number of elements to be added in the hashset.

'''


class MyHashSet:
    def __init__(self):
        self._buckets = 1000
        self._bucket_items = 1000
        self._storage = [None] * self._buckets

    def _get_bucket(self, key) -> int:
        return int(key % self._buckets)

    def _get_bucket_item(self, key) -> int:
        return int(key / self._bucket_items)

    def add(self, key: int) -> None:
        bucket = self._get_bucket(key)
        bucket_item = self._get_bucket_item(key)

        if self._storage[bucket] == None:
            if bucket == 0:
                self._storage[bucket] = [False] * (self._bucket_items + 1)
            else:
                self._storage[bucket] = [False] * self._bucket_items

        self._storage[bucket][bucket_item] = True

    def remove(self, key: int) -> None:
        bucket = self._get_bucket(key)
        bucket_item = self._get_bucket_item(key)

        if self._storage[bucket] == None:
            return

        self._storage[bucket][bucket_item] = False

    def contains(self, key: int) -> bool:
        bucket = self._get_bucket(key)
        bucket_item = self._get_bucket_item(key)
        answer = False if self._storage[bucket] == None else self._storage[bucket][bucket_item]
        return answer


# Driver code
myHashSet = MyHashSet()
myHashSet.add(1)      # set = [1]
myHashSet.add(2)      # set = [1, 2]
print(myHashSet.contains(1)) # return True
print(myHashSet.contains(3)) # return False, (not found)
myHashSet.add(2)      # set = [1, 2]
print(myHashSet.contains(2)) # return True
myHashSet.remove(2)   # set = [1]
print(myHashSet.contains(2)) # return False, (already removed)
