class ListNode:
    def __init__(self, key):
        self.key = key
        self.next = None
        
class MyHashSet:
    def __init__(self):
        self.set = [ListNode(0) for i in range(10**4)]
        
    def add(self, key:int) -> None:
        cur = self.set[key%len(self.set)]
        
        while cur.next:
            if  cur.next.key == key:
                return
            cur = cur.next
            
        cur.next = ListNode(key)
        
    def remove(self, key:int) -> None:
        cur = self.set[key%len(self.set)]
        
        while cur.next:
            if  cur.next.key == key:
                cur.next = cur.next.next 
                return
            cur = cur.next
            
    def contains(self, key:int) -> None:
        cur = self.set[key%len(self.set)]
        
        while cur.next:
            if  cur.next.key == key:
                return True
            cur = cur.next
        return False
