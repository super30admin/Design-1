# #  Time Complexity : O(1) for insert, and O(n) for remove and contains
# #  Space Complexity : O(n)
# #  Did this code successfully run on Leetcode : YES
# #  Any problem you faced while coding this :


# #  Your code here along with comments explaining your approach
# class MyHashSet:

#     # HashSet is an array of arrays lenght 10000. Constraint 0 <= key <= 10^6
#     def __init__(self):
#         self.n = 10000
#         self.arr = [[] for _ in range(self.n)]

#     # Hash function is mod of the length of the array 10000
#     # to find the array index in which a key will go, we will mod the key by 10000
#     # then check if the key already exist in the array at the given index and insert
#     # Complexity: O(1)
#     def add(self, key: int) -> None:
#         index = key % self.n
#         if key not in self.arr[index]:
#             self.arr[index].append(key)

#     # find the array index in which the key could be
#     # if present in the array, remove it
#     # Complexity: O(n)
#     def remove(self, key: int) -> None:
#         index = key % self.n
#         if key in self.arr[index]:
#             self.arr[index].remove(key)

#     # Complexity: O(n)
#     def contains(self, key: int) -> bool:
#         index = key % self.n
#         return key in self.arr[index]


# # Your MyHashSet object will be instantiated and called as such:
# # obj = MyHashSet()
# # obj.add(key)
# # obj.remove(key)
# # param_3 = obj.contains(key)



# Option 2 which uses 2 hash functions to achieve O(1) time complexity
class MyHashSet:

    def __init__(self):
        self.n = 1000
        self.arr = [[] for _ in range(self.n)]

    # Uses 2 hash function to reduce time complexity
    # Complexity: O(1)
    def add(self, key: int) -> None:
        bucket = key % self.n
        bucketIndex = key // self.n # 2nd hash function gives a unique index in the 2nd array
        if len(self.arr[bucket]) == 0: #init the 2nd array with default values as False
            # 1000000 will fall at index 1000, and our arrays only go to 999
            # hence the 1st bucket(0) will have 1 extra value 
            self.arr[bucket] = [False for _ in range(self.n + 1 if bucket == 0 else self.n)]
        
        # set the key's position to True when we insert into the array
        self.arr[bucket][bucketIndex] = True

    # Complexity: O(1)
    def remove(self, key: int) -> None:
        # to remove we simply compute the index for both arrays for the key
        # then set the 2nd array value to False to mark it as removed
        bucket = key % self.n
        bucketIndex = key // self.n
        if len(self.arr[bucket]) > 0:
            self.arr[bucket][bucketIndex] = False
        
    # Complexity: O(1)
    def contains(self, key: int) -> bool:
        bucket = key % self.n
        bucketIndex = key // self.n
        if len(self.arr[bucket]) > 0:
            return self.arr[bucket][bucketIndex] # simply return the value in the 2nd array
        else:
            return False



# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(2)
print(obj.contains(1))
print(obj.contains(3))
obj.add(2)
print(obj.contains(2))
obj.remove(2)
print(obj.contains(2))