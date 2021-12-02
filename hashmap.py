#time complexity: O(n)
#space complexity: O(n)

class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.nxt = None
        return
    
class MyHashMap:

    def __init__(self):
        self.bucket_size = 10000
        self.bucket = [None] * self.bucket_size
        return

    def get_index(self, key):
        return key % self.bucket_size
    
    def put(self, key, value):
        
        head = self.bucket[self.get_index(key)]
        
        if not head:
            self.bucket[self.get_index(key)] = Node(key, value)
            
        else:
            curr = head
            prev = None
            while curr:
                if curr.key == key:
                    curr.val = value
                    break
                prev = curr
                curr = curr.nxt
            else:
                prev.nxt = Node(key, value)
                    
            
        return
        

    def get(self, key):
        
        head = self.bucket[self.get_index(key)]

        if head:
            curr = head
            while curr:
                if curr.key == key:
                    return curr.val
                curr = curr.nxt
                
        return -1
        
    def remove(self, key):
        
        head = self.bucket[self.get_index(key)]
        if head:
            curr = head
            prev = None
            while curr:
                if curr.key == key:
                    if prev:
                        prev.nxt = curr.nxt
                    else:
                        head = curr.nxt
                    break
                prev = curr
                curr = curr.nxt
            self.bucket[self.get_index(key)] = head
                
        return