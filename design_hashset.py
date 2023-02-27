class MyHashSet:
    def __init__(self):
        self.capacity = 769
        self.arr = [LLBucket() for i in range(self.capacity)]

    def _hash(self, key: int) -> int:
        return key % self.capacity

    def add(self, key: int) -> None:
        self.arr[self._hash(key)].add(key)

    def remove(self, key: int) -> None:
        self.arr[self._hash(key)].remove(key)

    def contains(self, key: int) -> bool:
        return self.arr[self._hash(key)].contains(key)


class Node:
    def __init__(self, data: int):
        self.data = data
        self.next = None
    
    
class LLBucket():
    def __init__(self):
        self.head = Node(float('-inf'))
    
    def add(self, data: int):
        if not self.contains(data):
            newNode = Node(data)
            newNode.next = self.head.next
            self.head.next = newNode

    def remove(self, data: int):
        prev = self.head
        curr = self.head.next

        while curr:
            if curr.data == data:
                prev.next = curr.next
                return
            
            prev = curr
            curr = curr.next
    
    def contains(self, data: int) -> bool:
        curr = self.head.next

        while curr:
            print(f"{curr.data}; {data}")
            if curr.data == data:
                return True
            
            curr = curr.next
        
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)