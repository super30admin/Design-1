# Space Complexity: O(n)
class MyHashSet:
    def __init__(self):
        # Prime number for a good hash modular value
        self.capacity = 769
        self.arr = [LLBucket() for i in range(self.capacity)]

    # Time Complexity: O(1)
    def _hash(self, key: int) -> int:
        return key % self.capacity

    # Time Complexity: O(1)
    def add(self, key: int) -> None:
        self.arr[self._hash(key)].add(key)

    # Time Complexity: O(n)
    # Average case would be O(1) if no to extremely few collisions.
    # Worst case O(n) due to searching the "key" to be removed from the linked list bucket.
    def remove(self, key: int) -> None:
        self.arr[self._hash(key)].remove(key)

    # Time Complexity: O(n)
    # Average case would be O(1) if no to extremely few collisions.
    # Worst case O(n) due to searching the "key" from the linked list bucket.
    def contains(self, key: int) -> bool:
        return self.arr[self._hash(key)].contains(key)


class Node:
    def __init__(self, data: int):
        self.data = data
        self.next = None
    
    
class LLBucket():
    def __init__(self):
        self.head = Node(float('-inf'))
    
    # Time Complexity: O(1)
    def add(self, data: int):
        if not self.contains(data):
            newNode = Node(data)
            newNode.next = self.head.next
            self.head.next = newNode

    # Time Complexity: O(n)
    # Average case would be O(1) if no to extremely few collisions.
    # Worst case O(n) due to searching the "key" to be removed from the linked list bucket.
    def remove(self, data: int):
        prev = self.head
        curr = self.head.next

        while curr:
            if curr.data == data:
                prev.next = curr.next
                return
            
            prev = curr
            curr = curr.next
    
    # Time Complexity: O(n)
    # Average case would be O(1) if no to extremely few collisions.
    # Worst case O(n) due to searching the "key" from the linked list bucket.
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