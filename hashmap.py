# Time complexity - O(1) asymptotically
# Space complexity - O(n) 
# Using double hashing
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashmap = [None]*1000
        self.bucketSize = 1000
    
    
    def hashFunc1(self, key):
        return key%len(self.hashmap)
    
    
    def hashFunc2(self, key):
        return key//self.bucketSize
    

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        idx1 = self.hashFunc1(key) # find the index for the main bucket.
        idx2 = self.hashFunc2(key) # find the index for the sub-bucket.
        
        # create the subbucket at main bucket index if it doesn't exist.
        if self.hashmap[idx1] is None:
            self.hashmap[idx1] = [None]*self.bucketSize
        
        self.hashmap[idx1][idx2] = value
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        idx1 = self.hashFunc1(key) # find the index for the main bucket.
        idx2 = self.hashFunc2(key) # find the index for the sub-bucket.
        
        # create the subbucket at main bucket index if it doesn't exist.
        if self.hashmap[idx1] is None:
            return -1
        
        # check the value in the sub bucket.
        if self.hashmap[idx1][idx2] is None:
            return -1
    
        return self.hashmap[idx1][idx2]
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        idx1 = self.hashFunc1(key) # find the index for the main bucket.
        idx2 = self.hashFunc2(key) # find the index for the sub-bucket.
        
        # create the subbucket at main bucket index if it doesn't exist.
        if self.hashmap[idx1] is None:
            return 
        
        # check the value in the sub bucket.
        self.hashmap[idx1][idx2] = None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)

# Time complexity - O(1) asymptotic
# Space complexity - O(n) 
# Open addressing - Double Hashing
class Node:
    def __init__(self, key, value):
        self.key = key
        self.val = value
        self.next = None

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.len = 100
        self.hashmap = [None]*self.len
        
        
    def __hashFunc(self, key):
        """
            Function to hash key using a hash function.
        """
        return key % self.len 
    
        
    def __findElem(self, index, key):
        """
            Return None if the element is not found. Else return the element previous to the value you are looking for. 
        """
        # add the head node
        if not self.hashmap[index]:
            self.hashmap[index] = Node(float('inf'), float('inf')) 
            return self.hashmap[index]
        
        node = self.hashmap[index]
        while node.next and node.next.key!=key:
            node = node.next
        return node
    
    
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = self.__hashFunc(key)
        prev = self.__findElem(index, key)
        if not prev.next:
            prev.next = Node(key, value)
        else:
            prev.next.val = value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = self.__hashFunc(key)
        prev = self.__findElem(index, key)
        if not prev.next or (prev.next and prev.next.key != key):
            return -1
        return prev.next.val
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key.
        """
        index = self.__hashFunc(key)
        prev = self.__findElem(index, key)
        if prev.next and prev.next.key == key:
            prev.next = prev.next.next
        