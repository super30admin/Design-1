# // Time Complexity : O(1)
# // Space Complexity : 0(n) 
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
# // Create a Linked List
class ListNode:
    def __init__(self,key):
        self.key = key
        self.val = None
        self.next = None
    
    
    
    
class MyHashMap:
    
    def __init__(self):
        self.size = 1000
        self.bucket =[ ListNode(-1) for i in range(self.size)]
        

    def put(self, key: int, value: int) -> None:
        hasher = key % self.size
        head = self.bucket[hasher]  
        curr = head.next
        while curr :
            if curr.key == key:break
            head = curr
            curr = curr.next
            
        if not curr:
            curr = ListNode(key)
            curr.next = head.next
            head.next = curr
        curr.val = value
            
        
        
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hasher = key % self.size
        curr = self.bucket[hasher].next
        while curr:
            if curr.key == key:return curr.val
            curr = curr.next
        return -1
            
    
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hasher = key % self.size
        curr = self.bucket[hasher].next
        head = self.bucket[hasher]
        while curr:
            if curr.key == key:
                head.next = head.next.next
            
            head = curr
            curr = curr.next
            
            
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)