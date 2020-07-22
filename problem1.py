# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach 

class linkedListNode:
        def __init__(self, k, v):
            self.key = k
            self.value = v
            self.next = None

class MyHashMap:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashMap = [None for _ in range(1000)]
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hIndex = key//1000
        
        if self.hashMap[hIndex] is None:
            self.hashMap[hIndex] = linkedListNode(key, value)
            
        else:
            curr = self.hashMap[hIndex]
            while curr.next is not None:
                curr = curr.next
            curr.next = linkedListNode(key, value)
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hIndex = key//1000
        curr = self.getPrev(self.hashMap[hIndex], key)
        
        if curr.next is None:
            return -1
        else:
            return curr.next.value
                

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        curr = self.getPrev(self.hashMap[hIndex], key)
        
        if curr.next is not None:
            curr.next = curr.next.next

    def getPrev(self, node, key):
        prev = None
        
        while node.key != key and node.next is not None:
            prev = node
            node = node.next
            
        return prev
# Your MyHashMap object will be instantiated and called as such:
key, value = 10023, 65461
obj = MyHashMap()
obj.put(key,value)
param_2 = obj.get(key)
print(param_2)
obj.remove(key)