# // Time Complexity : O(N/Size) for all operations
# // Space Complexity : O(N+Size)
# // Did this code successfully run on Leetcode : No, got TLE
# // Any problem you faced while coding this : Got TLE for separate chaining

class Node:
    def __init__(self,key,value):
        self.key  = key
        self.value = value
        self.next = None
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashmap = [None]*10007
        self.capacity = 10007
        
    def hashValue(self,key):
        return key%self.capacity
    
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hash_value = self.hashValue(key)
        if self.hashmap[hash_value]== None:
            n = Node(key,value)
            self.hashmap[hash_value] = n
            return
        temp = self.hashmap[hash_value]
        while temp:
            if temp.key == key:
                temp.value = value
                return
            temp=temp.next
        n = Node(key,value)
        n.next =self.hashmap[hash_value]
        self.hashmap[hash_value] = n


    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hash_value = self.hashValue(key)
        
        if self.hashmap[hash_value]== None:
            return -1
        temp = self.hashmap[hash_value]
        while temp:
            if temp.key == key:
                return temp.value
            temp=temp.next
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hash_value = self.hashValue(key)
        
        if self.hashmap[hash_value]== None:
            return
        temp = self.hashmap[hash_value]
        if temp.key == key:
            self.hashmap[hash_value] = temp.next
            return
        while temp.next:
            if temp.next.key == key:
                temp.next = temp.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
