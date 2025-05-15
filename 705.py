from collections import deque as deque
class MyHashSet:

    def __init__(self):
        self.size = 1000
        self.hashset = [[False for _ in range(1000)] for _ in range(1000)]

    def getHash(self, key)::
        return key%self.size, key//self.size

    def add(self, key: int) -> None:
        if self.contains(key):
            return
        primary, secondary = self.getHash(key)
        self.hashset[primary][secondary] = True

    def remove(self, key: int) -> None:
        if not self.contains(key):
            return
        primary,secondary = self.getHash(key)
        self.hashset[primary][secondary] = False

    def contains(self, key: int) -> bool:
        primary, secondary = self.getHash(key)
        return self.hashset[primary][secondary]

