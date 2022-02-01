# Time Complexity : O(n/k) where k is size of hasharray
# Space Complexity : O(k) where k is size of hasharray
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

# Define a Linked List node with key-value pair
class Node:
    def __init__(self, key = 0, value = 0):
        self.data = (key, value)
        self.next = None

# Define a Linked List class
class LinkedList:

    # Linked List constructor
    def __init__(self):
        self.head = None
    
    # Add new unique key with its value to the Linked List
    def append(self, key, value):
        # If the key is already present in the Linked List, update it's value and return
        curr = self.head
        while curr:
            if curr.data[0] == key:
                curr.data = (key, value)
                return
            curr = curr.next 
        # Create New Node with key-value pair  
        newnode = Node(key, value)
        # If there is no head node, then the new node is the head node
        if not self.head:
            self.head = newnode
        # Else append the new node to the end of the Linked List
        else:
            curr = self.head
            while curr.next:
                curr = curr.next
            curr.next = newnode

    # Delete key from the Linked List        
    def delete(self, key):
        # If there is no head node, there is nothing to delete
        if not self.head:
            return
        # If head node contains the key to be deleted, delete it  
        if self.head.data[0] == key:
            temp = self.head
            self.head = self.head.next
            temp = None
        # Else find the node that contains the key and delete that node
        else:
            prev = self.head
            curr = prev.next
            while curr:
                if curr.data[0] == key:
                    prev.next = curr.next
                    curr = None
                    break
                prev = curr
                curr = curr.next
    
    # Get the value corresponding to the key in the Linked List
    # Iterate through the Linked List, if any node contains the key, then return the corresponding value, else return -1
    def getval(self, key):
        curr = self.head
        while curr:
            if curr.data[0] == key:
                return curr.data[1]
            curr = curr.next
        return -1

# Define the MyHashMap class 
class MyHashMap:

    # MyHashMap constructor
    def __init__(self):
        # I randomly chose the size of the hash array to be 2999
        self.hasharraysize = 2999
        # Create a LinkedList object at each index of the hash array
        self.hasharray = [LinkedList() for i in range(self.hasharraysize)]  

    # Hash Function
    def _hashfunction(self, key):
        return key % self.hasharraysize    

    # Add a new key-value pair to MyHashSet
    def put(self, key: int, value: int) -> None:
        # Use the Hash function to calculate the corresponding index of the hash array
        hasharrayindex = self._hashfunction(key)
        self.hasharray[hasharrayindex].append(key, value)

    # Get value corresponding to a key from MyHashSet
    def get(self, key: int) -> int:
        # Use the Hash function to calculate the corresponding index of the hash array
        hasharrayindex = self._hashfunction(key)
        # Return the value corresponding to the key from the Linked List at the calculated index of the hash array
        return self.hasharray[hasharrayindex].getval(key)

    # Remove a key from MyHashSet
    def remove(self, key: int) -> None:
        # Use the Hash function to calculate the corresponding index of the hash array
        hasharrayindex = self._hashfunction(key)
        # Delete the key from the Linked List at the calculated index of the hash array
        self.hasharray[hasharrayindex].delete(key)

hashMap = MyHashMap()
hashMap.put(1, 2)
hashMap.put(2, 3)
print(hashMap.get(1))
print(hashMap.get(3))
hashMap.put(2, 4)
print(hashMap.get(2))
hashMap.remove(2)
print(hashMap.get(2))