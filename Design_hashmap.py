class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None
        
class LinkedList:
    def __init__(self):
        self.prehead = Node(None, None)
        
    def search(self, key):      # time - O(n)
        p = self.prehead.next
        while p:
            if p.key == key:
                return p
            p = p.next
        return None
    
    def add(self, key, val):
        p = self.search(key)
        if p:
            p.val = val
        else:
            node = Node(key, val)
            node.next =  self.prehead.next
            self.prehead.next = node
            
    def get(self, key):
        p = self.search(key)
        if p:
            return p.val
        else:
            return -1
        
    def remove(self, key):
        prev = self.prehead
        cur = self.prehead.next
        while cur:
            if cur.key == key:
                break
            prev= cur
            cur = cur.next
        if cur:
            prev.next = cur.next
    
class MyHashMap:
    def __init__(self):
        self.size = 3833
        self.map = [LinkedList() for i in range(self.size)]
        
    def put(self, key, value):
        h = key % self.size
        self.map[h].add(key, value)
        
    def get(self, key):
        h = key % self.size
        result = self.map[h].get(key)
        return result
        
        
    def remove(self, key):
        h = key % self.size
        self.map[h].remove(key)