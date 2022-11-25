class MyHashSet:

    def __init__(self):
        self.size = 1000
        self.hashset = [None] * self.size

    def hash1(self, k):
        return k % self.size

    def hash2(self, k):
        return k // self.size

    def add(self, key: int) -> None:
        h1 = self.hash1(key)
        h2 = self.hash2(key)
        if self.hashset[h1] == None:
            if h1 == 0:
                self.hashset[h1] = [False] * (self.size + 1)
            else:
                self.hashset[h1] = [False] * self.size
            self.hashset[h1][h2] = [True]
        else:
            self.hashset[h1][h2] = [True]

    def remove(self, key: int) -> None:
        h1 = self.hash1(key)
        h2 = self.hash2(key)
        if self.contains(key):
            self.hashset[h1][h2] = False

    def contains(self, key: int) -> bool:
        h1 = self.hash1(key)
        if self.hashset[h1] == None:
            return False
        h2 = self.hash2(key)
        return self.hashset[h1][h2]


hashSet = MyHashSet();
l=[]
l.append(hashSet.add(1))

l.append(hashSet.add(2))

l.append(hashSet.contains(1))

l.append(hashSet.contains(3))

l.append(hashSet.add(2))

l.append(hashSet.contains(2))

l.append(hashSet.remove(2))


l.append(hashSet.contains(2))

print(l)
