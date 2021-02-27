'''
Time Complexity - O(N) 
Space Complexity - O(N) 

Algorithm - We are suing separate chaining to handle collision issue. Worst case when after hashing we are getting the same value and new key is being appended to it
'''

# ListNode to store key and value
class ListNode:
    def __init__(self,key,value):
        self.key = key
        self.value=value
        self.next = None
        
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 10000
        self.nodes = [None]*self.size
        
    # Hashing funtion
    def getHash(self,key):
        return key%self.size
    
    # this function returns the prev ListNode of the key. If it does not exist, then returns the last key
    # TC - O(N)
    def findElement(self,key,head):
        prev=None
        cur = head
        
        while(cur != None and cur.key!=key):
            prev=cur
            cur=cur.next
            
        return prev
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hash_value = self.getHash(key)
        if self.nodes[hash_value]==None:
            self.nodes[hash_value]=ListNode(-1,-1) # Creating a dummy node at the beginning
        prev = self.findElement(key,self.nodes[hash_value])
        
        # If key does not exist, then create a new ListNode with given key and value as next of prev node
        if prev.next==None:
            prev.next = ListNode(key,value)
            
        else:
            # else update the value of the key if key found Ask interviewer if he wants to update or return -1
            prev.next.value = value
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hash_value = self.getHash(key)
        
        # base case 
        if self.nodes[hash_value] == None:
            return -1
        prev = self.findElement(key,self.nodes[hash_value])
        
        if prev.next == None:
            return -1
        
        return prev.next.value
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hash_value = self.getHash(key)
        if self.nodes[hash_value] == None:
            return
        prev = self.findElement(key,self.nodes[hash_value])
        
        if prev.next==None:
            return
        
        prev.next=prev.next.next
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
        
# Driver code
hashmap = MyHashMap()
hashmap.put(1, 2)
hashmap.put(2, 3)
hashmap.get(1)            # returns 2
hashmap.get(3)            # returns -1 (not found)
hashmap.put(2, 4)         # update the existing value
hashmap.get(2)            # returns 4
hashmap.remove(2)         # remove the mapping for 2
hashmap.get(2)            # returns -1 (not found)