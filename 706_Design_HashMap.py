class Node:
    def __init__(self, key=None, value=None):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.length = 10000
        self.map = [None]*self.length
        
    def __getIndex(self, key):
        return key % self.length
    
    ### O(1)
    def __find(self,node, key):
        prev, curr = node, node
        while curr and (not curr.key == key):
            prev = curr
            curr = curr.next
        return prev

    ### O(1)
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = self.__getIndex(key)
        if self.map[index] is None:
            node = Node()
            self.map[index] = node
        
        prevNode = self.__find(self.map[index], key)
        if prevNode.next:
            prevNode.next.value = value
        else:
            prevNode.next = Node(key, value)
    
    ### O(1)
    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = self.__getIndex(key)
        if self.map[index] is None:
            return -1
        prevNode = self.__find(self.map[index], key)
        return prevNode.next.value if prevNode.next else -1
        
    ### O(1)
    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = self.__getIndex(key)
        if self.map[index] is None:
            return
        prevNode = self.__find(self.map[index], key)        
        if prevNode.next:
            prevNode.next = prevNode.next.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)