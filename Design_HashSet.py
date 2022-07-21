'''
Time Complexity - 
add() - O(1) 
remove() - O(1)
contains() - O(1)

Space Complexity - O(n)

'''


class MyHashSet:

    def __init__(self):
        self.hashset = 1000 * [None]
        self.hash1 = 1000

    def add(self, key: int) -> None:
        index = key % self.hash1
        index2 = key // self.hash1
        if self.hashset[index] == None and index == 0:
            self.hashset[index] = [False] * (self.hash1+1)
        elif self.hashset[index] == None:
            self.hashset[index] = [False] * (self.hash1)
        self.hashset[index][index2] = True

    def remove(self, key: int) -> None:
        if self.hashset[key % self.hash1] == None:
            return None
        self.hashset[key % self.hash1][key // self.hash1] = False

    def contains(self, key: int) -> bool:
        if self.hashset[key % self.hash1] == None:
            return None
        return self.hashset[key % self.hash1][key // self.hash1]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
