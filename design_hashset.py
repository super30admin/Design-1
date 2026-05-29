class MyHashSet:
    class Node:
        def __init__(self, key):
            self.key = key
            self.next = None

    def __init__(self):
        self.buckets = 1000
        self.storage = [None] * self.buckets

    def getHash(self, key):
        return key % self.buckets

    def getPrev(self, head, key):
        prev = None
        curr = head
        while curr != None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def add(self, key):
        index = self.getHash(key)
        if self.storage[index] == None:
            self.storage[index] = self.Node(-1)
            self.storage[index].next = self.Node(key)
            return

        prev = self.getPrev(self.storage[index], key)
        if prev.next == None:
            prev.next = self.Node(key)

    def remove(self, key):
        index = self.getHash(key)
        if self.storage[index] == None:
            return
        prev = self.getPrev(self.storage[index], key)
        if prev.next == None:
            return
        curr = prev.next
        prev.next = curr.next
        curr.next = None

    def contains(self, key):
        index = self.getHash(key)
        if self.storage[index] == None:
            return False
        prev = self.getPrev(self.storage[index], key)
        if prev.next == None:
            return False
        return True