# insert key by creating a hashed-key using modulus of the key (against number of elements)
# If hashed-key is same, then insert the key into singly linked list.

class Node:
    def __init__(self, val, next=None):
        self.val = val
        self.next = next

class Bucket:
    def __init__(self):
        self.head = Node(0)

    def insert(self, val):
        tempNode = self.head
        if (tempNode.next == None and tempNode.val == 0):
            tempNode.val = val
        else:
            while (tempNode.next != None):
                tempNode = tempNode.next
            tempNode.next = Node(val)

    def delete(self, val):
        tempNode = self.head
        if not self.exists(val):
            return

        if (tempNode and tempNode.next == None and tempNode.val == val):
            self.head = None
            return
        while (tempNode and tempNode.next and tempNode.next.val != val):
            tempNode = tempNode.next
        tempNode.next = tempNode.next.next
        return

    def exists(self, val) -> bool:
        tempNode = self.head
        while tempNode:
            if tempNode.val == val:
                return True
            tempNode = tempNode.next
        return False

class MyHashSet:
    def __init__(self):
        self.buckets = [Bucket() for i in range(100)]

    def add(self, key:int) -> None:
        new_key = key % 100
        self.buckets[new_key].insert(key)

    def remove(self, key:int) -> None:
        new_key = key % 100
        self.buckets[new_key].delete(key)

    def contains(self, key:int) -> bool:
        new_key = key % 100
        print(self.buckets[new_key].exists(key))

if __name__ == "__main__":
    hashSet = MyHashSet()
    hashSet.add(1)         
    hashSet.add(101)
    hashSet.remove(101)
    hashSet.contains(101)

        