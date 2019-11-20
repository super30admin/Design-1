# Create a list of constant size
# Get hashed valued by taking mod of key and size of list

# In put, check whether the hashed value exists in the list or not
# If it does not, add a new Node with key as key and value as value
# If it does exist, then traverse till we find the key and update its value
# If the key does not exist then add it at the end of the linked list for that hash

# To get, calculate hashed value of the key
# If hashed valued exists in the list, iterate through the linked list till we find the key
# If key found, return the value
# Else return -1 

# To remove, we will check whether the hashed value exists in the list or not
# If it does, we will check whether if it exists at the head
# If it does, we will point the fist node to current's next
# Else we will iterate till we find the key by keeping two pointers, prev and current
# If key found, change the prev.next to current.next

# Time Complexity: Worst Case: O(n) Too many collisions, Average Case: O(1)
# Space Complexity: O(n)

class Node(object):
    
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 100
        self.map = [None]*self.size
        
    def hashing(self, key):
        return key % self.size

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        hashed = self.hashing(key)
        if self.map[hashed] == None:
            self.map[hashed] = Node(key, value)
        else:
            current = self.map[hashed]
            while current:
                if current.key == key:
                    current.value = value
                    return 
                elif current.next == None:
                    break
                current = current.next
            current.next = Node(key, value)
        

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        hashed = self.hashing(key)
        if self.map[hashed]:
            current = self.map[hashed]
            while current:
                if current.key == key:
                    return current.value
                current = current.next
        return -1

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        hashed = self.hashing(key)
        if self.map[hashed]:
            current = self.map[hashed]
            prev = self.map[hashed]
            if not current:
                return
            elif current.key == key:
                self.map[hashed] = current.next
            else:
                current = current.next
                while current:
                    if current.key == key:
                        prev.next = current.next
                        break
                    else:
                        prev = prev.next
                        current = current.next
                    


# Your MyHashMap object will be instantiated and called as such:
hashMap = MyHashMap()
hashMap.put(1, 1)          
hashMap.put(2, 2)         
print(hashMap.get(1))
# // returns 1
print(hashMap.get(3))
# // returns -1 (not found)
hashMap.put(2, 1)
# // update the existing value
print(hashMap.get(2))
# // returns 1 
hashMap.remove(2)
# // remove the mapping for 2
print(hashMap.get(2))
# // returns -1 (not found) 