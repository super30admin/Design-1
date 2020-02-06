"""
Time complexity: O(1)
Space complexity: O(N)
Compiled on leetcode: Yes
Difficulties faced: Faced difficulties in remove function. 
I was checking for while current.next instead of while current
"""

class LinkedListNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None
        
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.array = [LinkedListNode(None, None) for i in range(10000)]
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = key % 10000
        head = self.array[index]
        while head.next:
            head = head.next
            if head.key == key:
                head.value = value
                return
        head.next = LinkedListNode(key, value)  
        
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = key % 10000
        head = self.array[index]
        while head.next:
            head = head.next
            if head.key == key:
                return head.value
                break
        return -1        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = key % 10000
        previous = self.array[index]
        current = previous.next
        while current:
            if current.key == key:
                previous.next = current.next
                break
            previous = previous.next
            current = current.next
                
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)