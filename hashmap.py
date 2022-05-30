# Time Complexity : O(1)
# Space Complexity : O(constraints)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach

class MyHashMap:
    def __init__(self):
        self.hashmap = {}

    def put(self, key: int, value: int) -> None:
        self.hashmap[key] = value

    def get(self, key: int) -> int:
        if key not in self.hashmap:
            return -1
        else:
            return self.hashmap[key]

    def remove(self, key: int) -> None:
        if key in self.hashmap:
            self.hashmap.pop(key)


# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1, 1)
obj.put(2, 2)
print(obj.get(3))
print(obj.get(1))
obj.put(2, 1)
print(obj.get(2))
obj.remove(2)
print(obj.get(2))


# Using double hashing
# class MyHashMap:
#     def __init__(self):
#         self.hashmaplength = 1000
#         self.hashmap = [[]] * self.hashmaplength
#
#     def hi(self, key):
#         return key % 1000
#
#     def hv(self, key):
#         return key // 1000
#
#     def put(self, key, value):
#         hi = self.hi(key)
#         hv = self.hv(key)
#         if not self.hashmap[hi] and hi == 0:
#             self.hashmap[hi] = [[]] * (self.hashmaplength+1)
#         elif not self.hashmap[hi]:
#             self.hashmap[hi] = [[]] * self.hashmaplength
#         self.hashmap[hi][hv] = value
#
#     def get(self, key):
#         hi = self.hi(key)
#         hv = self.hv(key)
#         if not self.hashmap[hi] or self.hashmap[hi][hv] == []:
#             return -1
#         else:
#             return self.hashmap[hi][hv]
#
#     def remove(self, key):
#         hi = self.hi(key)
#         hv = self.hv(key)
#         if not self.hashmap[hi] or not self.hashmap[hi][hv]:
#             return
#         else:
#             self.hashmap[hi][hv] = []
#
#
# check = MyHashMap()
# check.put(11, 0)
# print(check.hashmap[11][0])
# print(check.get(11))
# print(check.hashmap)


# Using linear chaining
# class Node:
#     def __init__(self, key, value):
#         self.key = key
#         self.value = value
#         self.next = None
#
#
# class Hashmap:
#     def __init__(self):
#         self.hashmap = [None] * 10000
#
#     def hash(self, key):
#         return key % 10000
#
#     def put(self, key, value):
#         hi = self.hash(key)
#         if not self.hashmap[hi]:
#             self.hashmap[hi] = Node(key, value)
#         else:
#             temp = self.hashmap[hi]
#             while temp:
#                 if temp.key == key:
#                     temp.value = value
#                     return
#                 prev = temp
#                 temp = temp.next
#             prev.next = Node(key, value)
#
#     def get(self, key):
#         hi = self.hash(key)
#         temp = self.hashmap[hi]
#         while temp:
#             if temp.key == key:
#                 return temp.value
#             temp = temp.next
#         return -1
#
#     def remove(self, key):
#         hi = self.hash(key)
#         temp = self.hashmap[hi]
#         if temp and temp.key == key:
#             self.hashmap[hi] = temp.next
#             return
#         while temp:
#             if temp.key == key:
#                 prev.next = temp.next
#                 return
#             prev = temp
#             temp = temp.next
#
#
# llist = Hashmap()
# llist.put(1, 1)
# llist.put(10001, 10)
# llist.remove(200)
# print(llist.get(10001))


# linear chaining
# class Node:
#     def __init__(self, key, value):
#         self.key = key
#         self.value = value
#         self.next = None
#
#
# class Hashmap:
#     def __init__(self):
#         self.hashmap = [None] * 10000
#
#     def hi(self, key):
#         return key % 10000
#
#     def push(self, key, value):
#         hi = self.hi(key)
#         if self.hashmap[hi] is None:
#             self.hashmap[hi] = Node(key, value)
#         else:
#             temp = self.hashmap[hi]
#             while temp:
#                 if temp.key == key:
#                     temp.value = value
#                     return
#                 prev = temp
#                 temp = temp.next
#             prev.next = Node(key, value)
#
#     def get(self, key):
#         hi = self.hi(key)
#         if self.hashmap[hi] is None:
#             return -1
#         else:
#             temp = self.hashmap[hi]
#             while temp.next and temp.key != key:
#                 temp = temp.next
#             if temp.key == key:  # while can break if temp.next is None
#                 return temp.value
#             return -1
#
#     def remove(self, key):
#         hi = self.hi(key)
#         temp = self.hashmap[hi]
#         if temp and temp.key == key:
#             self.hashmap[hi] = temp.next
#         elif temp:
#             while temp.next and temp.key != key:
#                 prev = temp
#                 temp = temp.next
#             if temp.key == key:  # while can break if temp.next is None, can be last element with-out the key
#                 prev.next = temp.next
#
#
# check = Hashmap()
# check.remove(10001)
# check.push(1, 1)
# check.push(1, 100)
# check.push(1000001, 200)
# check.remove(10001)
# print(check.hashmap[1].next.value)



