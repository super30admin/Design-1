"""
Time Complexity : O(1) with no collision; O(n) with collision
Space Complexity : O(n)

"""

class linked_list:
    def __init__(self, key = -1, val = -1, next = None):
        self.key = key 
        self.val = val 
        self.next = next

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.list = [None] * 10000
        self.hash_factor = 10000
        
    def hash_(self, key):
        return key % self.hash_factor
    
    def search(self, key, head):
        cur = head 
        prev = None 
        
        while cur:
            if cur.key == key:
                return prev
            prev = cur
            cur = cur.next
        return prev
    
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = self.hash_(key)
        
        if not self.list[index]:
            self.list[index] = linked_list()
        print(self.list[index])
        prev = self.search(key, self.list[index])
        
        if not prev.next:
            prev.next = linked_list(key, value)
        else:   
            prev.next.val = value
            

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = self.hash_(key)
        
        if not self.list[index]:
            return -1 
        
        prev = self.search(key, self.list[index])
        
        if not prev.next: return -1 
        else: return prev.next.val
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = self.hash_(key)
        if not self.list[index]:
            return 

        prev = self.search(key, self.list[index])
        if not prev.next: return 
        else:
            prev.next = prev.next.next
            

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)