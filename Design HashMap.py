class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashTable = [None for x in range(100)]
        
    def hashFunction(self, key):
        return key % len(self.hashTable)
    
    def findElement(self, index, key):
        if not self.hashTable[index]:
            self.hashTable[index] = Node(-1, -1)
            return self.hashTable[index]
        else:
            current = self.hashTable[index]
            while current.next and current.next.key != key:
                current = current.next
        
        return current

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        index = self.hashFunction(key)
        prevNode = self.findElement(index, key)
        
        if prevNode.next:
            prevNode.next.value = value
        else:
            prevNode.next = Node(key, value)

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        index = self.hashFunction(key)
        prevNode = self.findElement(index, key)
        
        if prevNode.next:
            return prevNode.next.value
        else:
            return -1
        

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        index = self.hashFunction(key)
        prevNode = self.findElement(index, key)
        
        if prevNode.next:
            prevNode.next = prevNode.next.next
            
        return

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
