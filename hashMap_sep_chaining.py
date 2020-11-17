class Node:
    def __init__(self,key):
        self.key = key
        self.value = None
        self.link = None

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 1000
        self.head = [Node(-1)]*self.size

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """

        head = self.head[key % self.size]
        current = head.link
        while current:
            if current.key == key: break
            current = current.link
        else:
            current = Node(key)
            current.link = head.link
            head.link = current
        current.value = value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """

        current = self.head[key % self.size].link
        while current:
            if current.key == key: break
            current = current.link
        else:
            return -1
        return current.value
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """

        current = self.head[key % self.size]
        while current and current.link:
            if current.link.key == key: break
            current = current.link
        else:
            return None
        current.link = current.link.link
        


# Your MyHashMap object will be instantiated and called as such:
hashMap = MyHashMap()
hashMap.put(1, 2)      
hashMap.put(2, 3)         
print(hashMap.get(1))         
print(hashMap.get(3) )          
hashMap.put(2, 4)          
print(hashMap.get(2))           
hashMap.remove(2)       
print(hashMap.get(2))           