class ListNode:
    def __init__(self, key, val):
        self.pair = (key, val)
        self.next = None


class MyHashMap:

    def __init__(self):
        self.x = [None] * 10000
        
    def index(self, key: int) -> int:
        return hash(key) % 10000
        
    def put(self, key: int, value: int) -> None:
        hashkey = index(key)
        
        if self.x[hashkey] == None:
            self.x[hashkey] = ListNode(key,value)
        else:
            curr = self.x[hashkey]
            while True:
                if curr.pair[0] == key:
                    curr.pair = (key,value)
                    return
                if curr.next == None:
                    break
                curr = curr.next
            curr.next = ListNode(key,value)
                    
        

    def get(self, key: int) -> int:
        hashkey = index(key)
        curr = self.x[hashkey]
        while curr:
            if curr.pair[0] == key:
                return curr.pair[1]
            else:
                curr = curr.next
        return -1
        

    def remove(self, key: int) -> None:
        hashkey = index(key)
        curr = self.x[hashkey]
        prev = self.x[hashkey]

        if not curr: return
        if curr.pair[0] == key:
            self.x[hashkey] = curr.next
        else:
            curr = curr.next
            while curr:
                if curr.pair[0] == key:
                    prev.next = cur.next
                    break
                else:
                    cur, prev = cur.next, prev.next
        
