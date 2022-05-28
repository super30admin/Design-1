# Time Complexity : O(1), in worst case max length of linked list is 100, which is constant compared to input 10^6
# Space Complexity : O(N) where N is total array size allocated 10^4, plus the number of elements added to each bucket is max 100 in worst case. 

class Node:
    
    def __init__(self, key,value):
        self.key = key
        self.value = value
        self.next= None
        
class MyHashMap:

    def __init__(self):
        self.buckets = 10000
        self.hashMap = [None for i in range(self.buckets)]
    
    def hashfunc(self, key):
        return key % self.buckets
    
    def find(self, head, key):
        prev = head
        curr = head.next
        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        bucket = self.hashfunc(key)
        if not self.hashMap[bucket]:
            self.hashMap[bucket] = Node(-1, -1)
        
        newNode = Node(key,value)
        prev = self.find(self.hashMap[bucket], key)
        if prev.next == None:
            prev.next = newNode
        else:
            prev.next.value = value
                

    def get(self, key: int) -> int:
        bucket = self.hashfunc(key)
        if not self.hashMap[bucket]:
            return -1
        else:
            prev = self.find(self.hashMap[bucket], key)
            # print(key, prev.key, prev.value, prev.next)
            if prev.next == None:
                return -1
            else:
                return prev.next.value

    def remove(self, key: int) -> None:
        bucket = self.hashfunc(key)
        if not self.hashMap[bucket]:
            return
        else:
            prev = self.find(self.hashMap[bucket], key)
            if prev.next == None:
                return
            else:
                prev.next = prev.next.next
        


obj = MyHashMap()
obj.put(1,10)
obj.put(1,20)
obj.put(3,30)
print(obj.get(2))
print(obj.get(1))
print(obj.get(3))
obj.remove(3)
print(obj.get(3))