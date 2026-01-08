"""
HashSet can be implemented in multiple way
1) One way is to use double hasing -- the idea here is to create a 2d array of size adjusted to the constraints
key % size and key / size will determine the column and then the row it goes belongs to
"""

class MyHashSet:

    def __init__(self):
        self.bucket = 1000
        self.bucketSize = 1000
        self.store = [[False] * self.bucket for _ in range(self.bucketSize)]
    
    def hash1(self, key):

        return key % self.bucket
    
    def hash2(self, key):

        return key // self.bucket

    def add(self, key: int) -> None:

        h1 = self.hash1(key)
        h2 = self.hash2(key)

        if h1 == 0:
            self.store[h1].append(False)
        self.store[h1][h2] = True
        

    def remove(self, key: int) -> None:
        
        h1 = self.hash1(key)
        h2 = self.hash2(key)

        self.store[h1][h2] = False

    def contains(self, key: int) -> bool:
        
        h1 = self.hash1(key)
        h2 = self.hash2(key)

        return self.store[h1][h2]
# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)



class Node:
    def __init__(self, key):
        self.key = key
        self.next = None

class MyHashSet:

    def __init__(self):
        self.store = [None] * 1000
    
    def hash1(self, key):
        return key % 1000
    
    def prev(self, key, head):

        prev = None
        curr = head

        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        
        return prev

    def add(self, key: int) -> None:
        h1 = self.hash1(key)

        if self.store[h1] is None:
            self.store[h1] = Node(-1)
            self.store[h1].next = Node(key)
            return
        
        prev = self.prev(key, self.store[h1])

        if prev.next is None:
            prev.next = Node(key)

    def remove(self, key: int) -> None:

        h1 = self.hash1(key)

        if self.store[h1] is None:
            return None

        prev = self.prev(key, self.store[h1])

        if prev.next is None:
            return None
        
        prev.next = prev.next.next
        
        

    def contains(self, key: int) -> bool:
        
        h1 = self.hash1(key)

        if self.store[h1] is None:
            return False
        
        prev = self.prev(key, self.store[h1])

        if prev.next is None:
            return False
        return True
        



# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)