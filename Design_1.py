class MyHashSet:
    '''
    Time Complexity:
    Adding an element (add method): O(1)
    Removing an element (remove method): O(1)
    Checking if an element exists (contains method): O(1)

    Space Complexity:
    Storage: O(n)
    '''

    def __init__(self):
        self.buckets = 1000  # Primary array size sqrt(rangelimit)
        # Secondary array size (rangelimit / Primary array size)
        self.bucketItems = 1000
        self.storage = [[] for _ in range(self.buckets)]

    def bucket(self, key):
        return key % self.buckets

    def bucketItem(self, key):
        return key // self.bucketItems

    def add(self, key: int) -> None:
        primary = self.bucket(key)
        secondary = self.bucketItem(key)
        while primary >= len(self.storage):
            self.storage.append([])

        while secondary >= len(self.storage[primary]):
            self.storage[primary].append(False)

        self.storage[primary][secondary] = True
        '''
        if not self.storage[primary]:
            self.storage[primary] = [False] * self.bucketItems
        self.storage[primary][secondary] = True
        '''

    def remove(self, key: int) -> None:
        primary = self.bucket(key)
        secondary = self.bucketItem(key)
        if primary < len(self.storage) and secondary < len(self.storage[primary]):
            self.storage[primary][secondary] = False

        '''
        if not self.storage[primary]:
            return
        self.storage [primary][secondary] = False
        '''

    def contains(self, key: int) -> bool:
        primary = self.bucket(key)
        secondary = self.bucketItem(key)
        return primary < len(self.storage) and secondary < len(self.storage[primary]) and self.storage[primary][secondary]

        '''
       if not self.storage[primary]:
           return False
       return self.storage[primart][secondary]
       '''


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
