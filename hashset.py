# time complexity:O(1) on average 
# space complexity: O(1)
class MyHashSet:

    def __init__(self):
        self.bucket_size = 1000 # declare the size of array 
        self.bucket = [[] for _ in range(self.bucket_size)]  # create a nested list

    def add(self, key: int) -> None:
        index = key % self.bucket_size      # calculate index and secodary index using modulo and integer division operations
        secondary_index = key // self.bucket_size
        if not self.contains(key):  # check if key present in contains
            self.bucket[index].append(secondary_index) # if not: append key into index 

    def remove(self, key: int) -> None:
        index = key % self.bucket_size      # delete the key 
        secondary_index = key // self.bucket_size
        if (
                index < len(self.bucket)
                and secondary_index in self.bucket[index]
        ):
            self.bucket[index].remove(secondary_index)

    def contains(self, key: int) -> bool:
        index = key % self.bucket_size
        secondary_index = key // self.bucket_size
        if (
                index < len(self.bucket)
                and secondary_index in self.bucket[index]
        ):
            return True
        else:
            return False

obj = MyHashSet()
obj.add(1)
obj.add(2)
print(obj.contains(1))
print(obj.contains(3))
obj.add(2)
print(obj.contains(2))
obj.remove(2)
print(obj.contains(2))
obj.add(1000000)
print(obj.contains(1000000))