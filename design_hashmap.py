# Design HashMap using Linked List
# Time Complexity = O(n)
# Space Complexity = O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Was having trouble when we insert value in the key whichc is already present in hash_map, but figured it out eventually using implementation of linkedlist.

# Code along with comments explaining the approach

class ListNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self):
        # We can keep the capacity as per our needs
        self.capacity = 1000
        self.hash_map = [None]*self.capacity

    def put(self, key, value):
        ind = key%1000
        if self.hash_map[ind]==None:
            # Create a new node because we have nothing in this cell
            self.hash_map[ind] = ListNode(key,value)
        else:
            # Traverse the cell checking to see if we have a matching key
            curr = self.hash_map[ind]
            while True:
                if curr.key==key:
                    curr.value = value
                    return
                if curr.next==None:
                    break
                curr = curr.next
            # Did not find a matching key here, so append a key, value pair in this cell
            curr.next = ListNode(key,value)
            
    def get(self, key):
        ind = key%1000
        if self.hash_map[ind] is None:
            return -1
        else:
            curr = self.hash_map[ind]
            while curr:
                if curr.key==key:
                    return curr.value
                else:
                    curr = curr.next
            return -1

    def remove(self, key):
        
        ind = key%1000
        curr = self.hash_map[ind]
        prev = curr
        
        if not curr:
            return 
        
        if curr.key==key:
            self.hash_map[ind] = curr.next
        else:
            curr = curr.next
            # We did not find the node to delete we must now traverse the bin
            while curr:
                if curr.key == key:
                    prev.next = curr.next 
                    break
                else:
                    prev = prev.next
                    curr = curr.next
                    
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)