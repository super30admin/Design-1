class ListNode:
    def __init__(self,key,val):
        self.pair = (key,val)
        self.next = None 

class MyHashMap:
    def __init__(self):
        self.size = 1000 
        self.hashing = [None] * self.size 
    
    def put(self,key,value):
        index = key % self.size 
        if self.hashing[index] == None: 
            self.hashing[index] = ListNode(key,value)
        else:
            cur = self.hashing[index]
            while True:
                if cur.pair[0] == key:
                    cur.pair= (key,value)
                    return 
                if cur.next == None:
                    break 
                cur = cur.next 
            cur.next = ListNode(key,value)
    
    def get(self,key):
        index = key % self.size 
        cur = self.hashing[index]
        while cur:
            if cur.pair[0] == key:
                return cur.pair[1]
            else:
                cur = cur.next 
        return -1 

    def remove(self,key):
        index = key % self.size 
        cur = prev = self.hashing[index]
        if not cur:
            return 
        
        if cur.pair[0] == key:
            self.hashing[index] = cur.next 
        else:
            cur = cur.next 
            while cur :
                if cur.pair[0] == key:
                    prev.next = cur.next 
                    break 
                else:
                    cur,prev = cur.next, prev.next 
                    
        