""""// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach"""



class MyHashMap:

    def __init__(self):
        self.dict = {}

    def put(self, key: int, value: int) -> None:
        self.dict[key] = value
        # print(self.dict[key])

    def get(self, key: int) -> int:
        if key not in self.dict:
            return -1
        else:
            return self.dict[key]

    def remove(self, key: int) -> None:
        if key in self.dict:
            self.dict.pop(key)
# Your MyHashMap object will be instantiated and called as such:
x = MyHashMap()
x.put(1, 10)
x.put(2, 5)
print(x.get(10))
print(x.get(2))
x.remove(1)
print(x.get(1))


class Node:
    def _init_(self, key, value):
        self.key = key
        self.value = value
        self.next = None


class Hashmap:
    def _init_(self):
        self.hashmap = [None] * 10000

    def hash(self, key):
        return key % 10000

    def put(self, key, value):
        hi = self.hash(key)
        if not self.hashmap[hi]:
            self.hashmap[hi] = Node(key, value)
        else:
            temp = self.hashmap[hi]
            while temp:
                if temp.key == key:
                    temp.value = value
                    return
                prev = temp
                temp = temp.next
            prev.next = Node(key, value)

    def get(self, key):
        hi = self.hash(key)
        temp = self.hashmap[hi]
        while temp:
            if temp.key == key:
                return temp.value
            temp = temp.next
        return -1

    def remove(self, key):
        hi = self.hash(key)
        temp = self.hashmap[hi]
        if temp and temp.key == key:
            self.hashmap[hi] = temp.next
            return
        while temp:
            if temp.key == key:
                prev.next = temp.next
                return
            prev = temp
            temp = temp.next


llist = Hashmap()
llist.put(1, 1)
llist.put(10001, 10)
llist.remove(10001)
print(llist.get(10001))el