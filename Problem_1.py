# Time Complexity : 
#                 Worst Case => O(n)
#                 Average Case => O(k), where k is the max length of one box in self.list
#                 Best Case => O(1)
# Space Complexity : O(n)

class MyHashSet:

    def __init__(self):
        self.list = [[] for i in range(15000)]  # Keeping the load factor < 1 (= 10000/15000)

    def hash_function(self, key):
        return key % 15000

    def add(self, key: int) -> None:
        hash_index = self.hash_function(key)
        if key not in self.list[hash_index]:
            self.list[hash_index].append(key)

    def remove(self, key: int) -> None:
        hash_index = self.hash_function(key)
        if key in self.list[hash_index]:
            self.list[hash_index].remove(key)

    def contains(self, key: int) -> bool:
        hash_index = self.hash_function(key)
        if key in self.list[hash_index]:
            return True
        else:
            return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)