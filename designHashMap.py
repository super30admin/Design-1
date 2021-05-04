class Node:
    def __init__(self, key, value):
        self.value = value
        self.key = key
        self.next = None

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.size = 10000
        self.buckets = []
        for i in range(self.size):
            self.buckets.append(None)
        self.head = None
        
        
    def index(self, key) -> int:
        return hash(key)%len(self.buckets)
    
    def find(self, head: Node, key: int):
        curr = head
        prev = None
        
        while curr and curr.key !=key:
            prev = curr
            curr = curr.next
        
        # print(prev.value)

        return prev

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        
        if self.buckets[self.index(key)] is None:
            self.buckets[self.index(key)] = Node(-1,-1)
            
        
        prev = self.find(self.buckets[self.index(key)], key)
        
        if prev.next is None:
            prev.next = Node(key,value)
        else:
            prev.next.value = value
    
    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        # print(self.size)
        # print(len(self.buckets))
        # print(key%self.size)
        # print(index(key))
        if self.buckets[self.index(key)] is None:
            return -1
        prev = self.find(self.buckets[self.index(key)], key)
        
        if prev.next is None:
            return -1
        
        return prev.next.value
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        if self.buckets[self.index(key)] is None:
            return -1
        prev = self.find(self.buckets[self.index(key)], key)
        
        if prev.next is None:
            return -1
        
        prev.next = prev.next.next
    


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
