"""
Time complexity:
Put: O(1)
Get: O(m) where m is the hashmap size we difined
Remove: O(m)

Space complexity:
O(1) for every thing.
"""
class Node:
    
    def __init__(self,tup = [-1,-1],next = None):
        self.next = next
        self.tup = tup
        
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.Map = [Node() for i in range(0,1000)]
        self.chabi = 1000
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hashkey = key % self.chabi
        temp = self.Map[hashkey]
        while temp.next is not None:
            if temp.next.tup[0] == key:
                temp.next.tup[1] = value
                return None
            temp = temp.next
        temp.next = Node(tup = [key,value])
        return None
            
    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashkey = key % self.chabi
        temp = self.Map[hashkey]
        while temp.next is not None and temp.next.tup[0] != key:
            temp = temp.next
        if temp.next is None:
            return -1
        else:
            return temp.next.tup[1]
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashkey = key % self.chabi
        temp = self.Map[hashkey]
        while temp.next is not None and temp.next.tup[0] != key:
            temp = temp.next
        if temp.next is None:
            return None
        else:
            temp.next = temp.next.next
        return None
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)