# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MyHashSet:

    def __init__(self):
        self.hash_table_size = 1300031
        self.array = [None] * self.hash_table_size
        self.q = 999983

    def add(self, key: int) -> None:
        idx = key % self.hash_table_size
        step = self.q - (key % self.q)
        first_del_idx = None

        while self.array[idx] is not None:
            if self.array[idx] == key:
                return

            if self.array[idx] == "DEL" and first_del_idx is None:
                first_del_idx = idx
            
            idx = (idx + step) % self.hash_table_size
        
        if first_del_idx is not None:
            self.array[first_del_idx] = key
        else:
            self.array[idx] = key

    def remove(self, key: int) -> None:
        idx = key % self.hash_table_size
        step = self.q - (key % self.q)

        while self.array[idx] is not None:
            if self.array[idx] == key:
                self.array[idx] = "DEL"
                return
            idx = (idx + step) % self.hash_table_size


    def contains(self, key: int) -> bool:
        idx = key % self.hash_table_size
        step = self.q - (key % self.q)

        while self.array[idx] is not None:
            if self.array[idx] == key:
                return True
            idx = (idx + step) % self.hash_table_size
        return False
    

# Uncomment below this line for Unit Testing:
# my_hash_set = MyHashSet()

# my_hash_set.add(10)
# my_hash_set.add(20)
# print(my_hash_set.contains(10))
# print(my_hash_set.contains(30))

# my_hash_set.add(1)
# my_hash_set.add(1300032)
# my_hash_set.add(2600063)

# print(my_hash_set.contains(1300032))
# print(my_hash_set.contains(2600063))

# my_hash_set.remove(1300032)
# print(my_hash_set.contains(1300032))

# print(my_hash_set.contains(2600063))

# my_hash_set.add(3900094) 
# print(my_hash_set.contains(3900094))