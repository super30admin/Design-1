# Successfully submitted on leetcode
# Time complexity : O(1)
#Space complexity : O(n)
# Initializing the Linked list
class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:
# Initialize the hashmap of size 10^4
    def __init__(self):
        self.hashMap = [None] * 10000

    def put(self, key: int, value: int) -> None:
# Finding the hashkey
        hashkey = key % 10000
# Create a new node that entry is empty
        if self.hashMap[hashkey] == None:
            self.hashMap[hashkey] = Node(key, value)
        else:
# If key is present, update its value, else add keyvalue pair to the chain
            ptr = self.hashMap[hashkey]

            while ptr:
                if ptr.key == key:
                    ptr.value = value
                    return
                if ptr.next == None:
                    break
                ptr = ptr.next
            ptr.next = Node(key, value)

    def get(self, key: int) -> int:
        hashkey = key % 10000
        
        ptr = self.hashMap[hashkey]
# If key is present, return its value
        while ptr:
            if ptr.key == key:
                return ptr.value
            else:
                ptr = ptr.next

# If not present, return -1
        return -1

    def remove(self, key: int) -> None:

        hashkey = key % 10000
# Assigning hashmap entry to current and previous node
        curr = prev = self.hashMap[hashkey]
# if no node is present return node
        if not curr:
            return None
# Remove key if present at first position
        if curr.key == key:
            self.hashMap[hashkey] = curr.next
        else:
 # If key is found, remove key by connecting previous to next of current node
            curr = curr.next
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