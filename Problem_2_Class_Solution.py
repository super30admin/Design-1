# Time Complexity : O(100) i.e O(n/k) where n = 10^6 and k = 10,000. We chose bucket size as 10,000 so time complexity is O(100) which is pretty much as good as constant time
# Space Complexity : O(n) where n is the number of keys possible
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

### DESIGNING HASH MAP ###

class Node:
    # Class to define node
    def __init__(self,key):
        self.key = key # Initialize node with key and next pointing to none
        self.next = None
class MyHashSet:

    def __init__(self):
        self.buckets = 10000 # We chose 10000 buckets so that each linked list has a max size of 1000 and O(100) is acceptable time complexity
        self.hashSet = [None]*self.buckets # Initialize hashSet with 10,000 elements
    
    def hash(self,key:int) -> int:
        return key%self.buckets # Calculate hash keyue as modulo of key with 10,000
    
    def find(self, node: Node,key: int) -> Node:
        # To find the index of previous node which will help in adding or removing from the linked list
        prev = None # Initialize prev to none and curr with node
        curr = node
        while(curr and curr.key != key): # While curr is not null and keyue is not key keep going to the next element
            prev = curr # Store current curr as prev and move curr to curr.next
            curr = curr.next
        return prev # Return prev as it points to the node before target key(or the last node in case key is not found)

    def add(self, key: int) -> None:
        idx = self.hash(key) # Calculate index by calling hash
        
        if(not self.hashSet[idx]):
            self.hashSet[idx] = Node(-1) # Create a linked list at the index in hashSet if it doesn't already exist
            # Create base i.e head of linked list with keyue -1 as all keys are 0 or higher in keyue
        
        prev = self.find(self.hashSet[idx],key) # Find previous node to target key (or the last node in case key is not found)
        
        if not prev.next: # If there is no element after prev, create a node with key as key and assign it to next of prev
            prev.next = Node(key)
        else:
            prev.next.key = key # If element exists at the key keyue we update the key
            # This step is actually redundant as I can simply got to the end of the list and add key as keys are unique and we don't have to update keyue at key like in hashmaps. I still wrote it this way because this solution was discussed for hashmaps and io wanted to execute this in such a manner that I can use the same code for hashmaps as well (with slight modifications like adding a keyue as well in Node)

    def remove(self, key: int) -> None:
        idx = self.hash(key)
        if not self.hashSet[idx]:
            return
        prev = self.find(self.hashSet[idx],key)  # Find previous node to target key (or the last node in case key is not found)
        
        if not prev.next:
            return
        prev.next = prev.next.next
     
    def contains(self, key: int) -> bool:
        idx = self.hash(key)
        if not self.hashSet[idx]:
            return
        prev = self.find(self.hashSet[idx],key)  # Find previous node to target key (or the last node in case key is not found)
        
        if not prev.next:
            return False
        else:
            return True


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)