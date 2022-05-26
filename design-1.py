# design-1
# LC 705

class MyHashSet:

    def __init__(self):
        self.size = 9991
        self.buckets = [None]*self.size
        

    def add(self, key: int) -> None:
        bucketNum = key% self.size
        curr = self.buckets[bucketNum]
        if not curr:
            self.buckets[bucketNum]= listNode(key, None)
            return
        if curr.key == key:
            return
        while curr:
            if curr.key == key:
                return
            if not curr.next:
                curr.next = listNode(key, None)
                return
            if curr.next:
                curr = curr.next
        return

    def remove(self, key: int) -> None:
        bucketNum = key%self.size
        curr = self.buckets[bucketNum]
        if not curr:
            return
        if curr.key ==key:
            self.buckets[bucketNum] =curr.next
        while curr.next:
            if curr.next.key ==key:
                curr.next = curr.next.next
                return
            curr = curr.next
            return
        
    def contains(self, key: int) -> bool:
        bucketNum = key%self.size
        curr = self.buckets[bucketNum]
        while curr:
            if curr.key==key:
                return True
            curr= curr.next
        return False
                        
class listNode(object):
    def __init__(self, key, next):
        self.key = key
        self.next = next
        

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)