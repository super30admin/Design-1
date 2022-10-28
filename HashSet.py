# Time Complexity : O(1) for adding, deleting and checking
# Space Complexity : O(N) since we are using 2 arrays of size 10^3
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashSet:

    def __init__(self):
        self.size = 1000
        self.arr = [None]*self.size

    def hash1(self,key):
        return (key % self.size)

    def hash2(self,key):
        return (key // self.size)

    def add(self, key: int) -> None:
        main_idx = self.hash1(key)
        bucket_idx = self.hash2(key)
        if self.arr[main_idx] == None:
            if main_idx == 0:
                self.arr[main_idx] = [False]*(self.size + 1)
            else:
                self.arr[main_idx] = [False]*(self.size)
        self.arr[main_idx][bucket_idx] = True

    def remove(self, key: int) -> None:
        main_idx = self.hash1(key)
        bucket_idx = self.hash2(key)
        if self.arr[main_idx]:
            self.arr[main_idx][bucket_idx] = False
            return
        else:
            return

    def contains(self, key: int) -> bool:
        main_idx = self.hash1(key)
        bucket_idx = self.hash2(key)
        if self.arr[main_idx]:
            return (self.arr[main_idx][bucket_idx])
        else:
            return False

# Initial Approach using Chaining
# Any problem you faced while coding this : Still unsure of the time & space complexity.
# Took a lot of Time to understand the concept
# also took time to get the proper intuition.
# class ListNode:
#     def __init__(self, key):
#         self.key = key
#         self.next = None

# class MyHashSet:

#     def __init__(self):
#         self.size = 1051
#         self.arr = [None] * self.size

#     def add(self, key: int) -> None:
#         main_idx = key%self.size

#         flag = self.contains(key)

#         if self.arr[main_idx]:
#             if not flag:
#                 curr_node = self.arr[main_idx]
#                 self.arr[main_idx] = ListNode(key)
#                 self.arr[main_idx].next = curr_node
#         else:
#             self.arr[main_idx] = ListNode(key)

#     def remove(self, key: int) -> None:
#         main_idx = key%self.size

#         if self.arr[main_idx]:
#             current = self.arr[main_idx].next
#             prev = self.arr[main_idx]

#             if prev.key == key:
#                 self.arr[main_idx].key = None
#                 return

#             while current:
#                 if current.key == key:
#                     prev.next = current.next
#                     return
#                 prev = current
#                 current = current.next


#     def contains(self, key: int) -> bool:
#         main_idx = key%self.size
#         if self.arr[main_idx] == None:
#             return False
#         else:
#             curr = self.arr[main_idx]
#             while curr:
#                 if curr.key == key:
#                     return True
#                 curr = curr.next
#         return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)