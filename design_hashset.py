### hashset implementation using LinkedList
### Complexity for operation : add = O(1)
### Complexity for operation : remove = O(n)
### Complexity for operation : contains = O(n)

class ListNode:
    def __init__(self, val=None, next = None):
        self.val = val
        self.next = next

class Bucket:
    def __init__(self):
        self.dummy = ListNode(-1)
    
    def present(self, key):
        tmp = self.dummy.next
        while tmp is not None:
            if tmp.val == key:
                return True
            tmp = tmp.next
        return False
    
    def add_key(self, key):
        if not self.present(key):
            new_node = ListNode(key, self.dummy.next)
            self.dummy.next = new_node
            
    
    def remove_key(self, key):
        if self.dummy.next is None:
            return
        
        tmp = self.dummy.next
        if tmp.val == key:
            self.dummy.next = tmp.next
            return
        
        while tmp.next:
            if tmp.next.val == key:
                tmp.next = tmp.next.next
                return
            tmp = tmp.next
                

class MyHashSet:

    def __init__(self):
        self.bucket_size = 1000
        self.hs = [Bucket() for i in range(self.bucket_size)]
    
    def calc_idx(self, key):
        return key % self.bucket_size

    def add(self, key: int) -> None:
        idx = self.calc_idx(key)
        self.hs[idx].add_key(key)
            
            
    def remove(self, key: int) -> None:
        idx = self.calc_idx(key)
        self.hs[idx].remove_key(key)

    def contains(self, key: int) -> bool:
        idx = self.calc_idx(key)
        return self.hs[idx].present(key)
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)