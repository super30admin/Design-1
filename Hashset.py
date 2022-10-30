#executed on leetcode
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
    
class MyHashSet:    
    
    def __init__(self):
        self.size = 1000
        self.arr = [None]*self.size

    def find_index(self, key):
        return key % self.size
    
    def find_value(self, key):
        idx = self.find_index(key)
        head = self.arr[idx]
        while head:
            if head.val == key: return 1
            head = head.next
        return 0

    def add(self, key: int) -> None:
        if self.find_value(key): return
        idx = self.find_index(key)
        self.arr[idx] = ListNode(key, self.arr[idx])

    def remove(self, key: int) -> None:
        idx = self.find_index(key)
        node = self.arr[idx]
        if node is None: 
            return 
        if node.val==key:
            self.arr[idx] = node.next
            return 
        first, second = node, node.next
        while second:
            if second.val == key:
                first.next = second.next
                return
            first, second = first.next, second.next

    def contains(self, key: int) -> bool:
        return self.find_value(key)

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)