#Time Complexity - put(): Average case -O(1), Worst case - O(n) where n = total inputs
# get(): Average case -O(1), Worst case - O(n) where n = total inputs
# remove() : Average case -O(1), Worst case - O(n) where n = total inputs
#Space Complexity - Overall it's O(n) where n are total inputs but all function implementations are O(1)

# Running on leetcode : Yes

#Node for linked list 
class ListNode(object):
    
    def __init__(self,key,val):
        self.pair = (key,val)
        self.next = None

#Hashmap implementation       
class MyHashMap(object):
    # Initilization of the hashmap class
    def __init__(self):
        self.size = 1000
        self.buckets = [None]*self.size
    
    # Function to add the key-value pair in the hashmap   
    def put(self, key, value):
        bucket = key%self.size
        cur = self.buckets[bucket]
        if not cur:
            self.buckets[bucket]=ListNode(key,value)
        else:
            while True:
                if cur.pair[0]==key:
                    cur.pair=(key,value)
                    return
                if not cur.next:
                    break
                cur = cur.next
            cur.next = ListNode(key,value)
        
    # Function to get the value based on key as input
    def get(self, key):
        bucket = key%self.size
        cur = self.buckets[bucket]
        
        while cur:
            if cur.pair[0]==key:
                return cur.pair[1]
            else:
                cur = cur.next
        return -1
    # Function to remove a value based on key as input
    def remove(self, key):
        bucket = key%self.size
        cur = prev = self.buckets[bucket]
        if not cur:
            return
        if cur.pair[0]==key:
            self.buckets[bucket] = cur.next
        else:
            cur = cur.next 
            while cur:
                if cur.pair[0]==key:
                    prev.next=cur.next
                    break
                else:
                    cur, prev = cur.next, prev.next
                    
                
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)