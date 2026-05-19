'''
The hashset is initialized as array of size 10**3 with None.
Once we have a key to add, we calculate the hash using // operation to get the first 3 digits.
Then we add the key to that particular index in the array.

If there is a collision, create another array of size 10**3 at the index and will treat it as a
second level hashmap. For this hashmap we will use the % operation to get the last 3 digits.
We finally add the key to that particular index in that array.

'''
class MyHashSet:

    def __init__(self):
        self.hashSet = [None for _ in range(1000+1)]

    def add(self, key: int) -> None:
        row = key // 1000
        col = key % 1000

        if self.hashSet[row] is None:
            self.hashSet[row] = [False for _ in range(1000+1)]
            
        self.hashSet[row][col] = True
        

    def remove(self, key: int) -> None:
        row = key // 1000
        col = key % 1000

        if self.hashSet[row] is not None and self.hashSet[row][col] is True:
                self.hashSet[row][col] = False

    def contains(self, key: int) -> bool:
        row = key // 1000
        col = key % 1000

        if self.hashSet[row] is not None:
                return self.hashSet[row][col]
        
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)