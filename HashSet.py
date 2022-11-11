# Time Complexity : O(1) for adding, deleting and checking
# Space Complexity : O(N) since we are using 2 arrays of size 10^3
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashSet:
    # Initialize Hashset with a value of sqrt of the range of acceptable size in the problem
    def __init__(self):
        self.size = 1000
        self.arr = [None]*self.size

    # Hash function for lookup in main array
    def hash1(self,key):
        return (key % self.size)

    # Hash function for lookup in bucket array
    def hash2(self,key):
        return (key // self.size)

    # if the main array has none at the obtained location, intialize a new boolean array
    # now if it is in the 0th bucket we need to cover for the case where key=10^6 -> hash2= 1000
    # which would be out of index range, so just for that case we use size+1, otherwise
    # the bucket will have 0-999 i.e 1000 elements
    # if there already exists an array at the location just change the bool at that index
    # O(1)
    def add(self, key: int) -> None:
        main_idx = self.hash1(key)
        bucket_idx = self.hash2(key)
        if self.arr[main_idx] == None:
            if main_idx == 0:
                self.arr[main_idx] = [False]*(self.size + 1)
            else:
                self.arr[main_idx] = [False]*(self.size)
        self.arr[main_idx][bucket_idx] = True

    # if arr[main_idx] is None -> location is empty, nothing to remove, then return
    # else change the bool variable at the bucket to False
    def remove(self, key: int) -> None:
        main_idx = self.hash1(key)
        bucket_idx = self.hash2(key)
        if self.arr[main_idx]:
            self.arr[main_idx][bucket_idx] = False
            return
        else:
            return

    # if arr[main_idx] is None -> location is empty, nothing to remove, then return False
    # else return the bool variable stored in the bucket
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