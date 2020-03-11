"""
// Time Complexity : 
    put - O(1)
    get - O(1)
    remove -  O(1)

// Space Complexity : 
    O(n) for using array
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : None
// Your code here along with comments explaining your approach
Algorithm explanation
- Initialize hashtable with size 1000, Each index holds a pointer to head of doubly linked list
- Define a hash function using prime number modulo for given key
- put
    Get the hash value of the key to be inserted(index)
    add the value at the obtained index and append the element at tail of the linked list
- get
    - Get the hash value of the key to be fetched
    - Iterate along the linked list till the element is found
    - else return -1
- remove
    - Get the hash value of the key to be removed
    - Iterate along the linked list till the value is found, delete the node using prev and next pointers
    - else return -1
"""

class Node:
    def __init__(self,key,value):
        self.prev = None
        self.next = None
        self.key = key
        self.value = value

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashtable = [None]*13
        self.prime_mod = 13
    
    def get_hash_value(self,key):
        return key % self.prime_mod
    
    def print_list(self,head):
        curr = head
        while curr:
            #print((curr.key,curr.value),end = " ")
            curr = curr.next

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hv = self.get_hash_value(key)
        newnode = Node(key,value)
        if not self.hashtable[hv]:
            self.hashtable[hv] = newnode
            self.hashtable[hv].next = None
            self.hashtable[hv].prev = None
        else:
            curr = self.hashtable[hv]
            #find for the key 
            update = False
            while curr:
                if curr.key == key:
                    curr.value = value
                    update = True
                curr = curr.next
            if not update:
                newnode.next = self.hashtable[hv].next
                if self.hashtable[hv].next:
                    self.hashtable[hv].next.prev = newnode
                newnode.prev = self.hashtable[hv]
                self.hashtable[hv].next = newnode
                
            # curr.next = newnode
            # newnode.prev = curr
        #print("Printing for hv",hv,key,value)
        #self.print_list(self.hashtable[hv])
        #print()

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hv = self.get_hash_value(key)
        curr = self.hashtable[hv]
        value = -1
        #print("GET ME THE KEY",key)
        while curr:
            #print("Keys in the get for the key",curr.key)
            if curr.key == key:
                value = curr.value
                #print("KEy to fetch found for value",key,value)
            curr = curr.next
        return value

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hv = self.get_hash_value(key)
        curr = self.hashtable[hv]
        while curr:
            if curr.key == key:
                #print("KEy to remove found",key)
                break
            curr = curr.next
        
        if curr:
            #print("curr value",curr.key,curr.value)
            if not curr.prev:
                self.hashtable[hv] = self.hashtable[hv].next
                if self.hashtable[hv]:
                    self.hashtable[hv].prev = None
            else:
                currprev = curr.prev
                print(currprev.key,currprev.value)
                currnext = curr.next
                currprev.next = currnext
                if currnext:
                    print(currnext.key,currnext.value)
                    currnext.prev = currprev
                #currnext.prev = currprev
                # curr.next.prev = curr.prev
                # currnext = curr.next
                
                #curr.prev.next = currnext
        
        #print("Removing the key",key,hv)
        #self.print_list(self.hashtable[hv])
        
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)