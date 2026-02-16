#Design HashSet

# use an array of size 1000, with each elemnt can have another array of 1000 giving us range 10^6 key limit
# Using the hashing functions as // and % for keeps the time constraints for each operations O(1)
# as only when collision happens new sub array is initialized, and that to of max length 1000 so avg case is O1
# space complexity will be in worst case O(n) where n is the keys added
class MyHashSet:

    def __init__(self):
        self.primaryArr = [False] * 1001

    def add(self, key: int) -> None:
        primaryHash = self.primaryHash(key)
        if self.primaryArr[primaryHash] == False:
            self.primaryArr[primaryHash] = [False]*1000
        secondaryHash = self.secondaryHash(key)
        self.primaryArr[primaryHash][secondaryHash] = True

    def remove(self, key: int) -> None:
        primaryHash = self.primaryHash(key)
        secondaryHash = self.secondaryHash(key)
        if self.primaryArr[primaryHash]:
            self.primaryArr[primaryHash][secondaryHash] = False

    def contains(self, key: int) -> bool:
        primaryHash = self.primaryHash(key)
        secondaryHash = self.secondaryHash(key)
        if self.primaryArr[primaryHash]:
            return self.primaryArr[primaryHash][secondaryHash]
        return False
    
    def primaryHash(self, key):
        return key//1000
    
    def secondaryHash(self, key):
        return key%1000

