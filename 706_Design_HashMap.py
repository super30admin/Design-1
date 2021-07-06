# Time Complexity :
#   put: 
#       O(1) [Best case -> There is no or minimal collision]
#       O(n) [Worst case -> All keys inserted generate the same hash code] 
#   get:
#       O(1) [Best case -> The first element in the hash code linked list is the required element]
#       O(n) [Worst case -> All keys inserted generate the same hash code. The last element in the hash code linked list is the required element]
#   remove: O(1)
#       O(1) [Best case -> The first element in the hash code linked list is the required element]
#       O(n) [Worst case -> All keys inserted generate the same hash code. The first element in the hash code linked list is the required element]
# 
# Space Complexity : O(n) [n is the number of elements inserted into Map]
# 
# Did this code successfully run on Leetcode : Yes
# 
# Any problem you faced while coding this : No, but I am not sure if this is the optimal approach


# Your code here along with comments explaining your approach
# 1. Initialize a <hashmap> list with 10 NULL values. Use MOD 10 value of the input key to generate hash code[0-9]. The hash code generation function used is quite simple. In a real time scenario it should be such that the chances of collision are negligible.
# 2. Each index of the <hashmap> hold a Linked list which containes nodes of type <HashNode>

class HashNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashmap = [None for i in range(10)] 
        

    def getHashCode(self, key):
        """
        It returns a value between 0 to 9
        """
        return key % 10
    
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hashcode = self.getHashCode(key) 
        if None == self.hashmap[hashcode]: # No collision case, so we directly insert the value
            self.hashmap[hashcode] = HashNode(key, value)
        else: # Collision, 
            p = self.hashmap[hashcode]
            if p.next is None: # If there is only one HashNode in the linked list present at the key
                if p.key == key: # Update on existing HashNode
                    p.value = value
                else: # insertion of new Node
                    p.next = HashNode(key, value)
                return
            while p.next is not None:
                if p.key == key:# Update on existing HashNode
                    p.value = value
                    return
                p = p.next
            if p.key == key: # Check if the very last node in the end of linked list has the same key, if yes the update the value
                p.value = value
            else: # Insert new node at the end of list
                p.next = HashNode(key, value)

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashcode = self.getHashCode(key)
        if self.hashmap[hashcode] is None: # There is no linked list present at the hash code index, so return -1
            return -1
        p = self.hashmap[hashcode]
        while p is not None: # Iterate over the hash code list and check if the key matches, if it does return the value
            if p.key == key:
                return p.value
            p = p.next
        return -1 # The value is not found so return -1
         

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashcode = self.getHashCode(key)
        if self.hashmap[hashcode] is not None: # Check if there is any hash node linked list at the hashnode index
            p = self.hashmap[hashcode]
            if p.key == key: # The first Node is the required element
                if p.next is None:
                    self.hashmap[hashcode] = None
                else:
                    self.hashmap[hashcode] = p.next
                return
            else: # Iterate over the list to locate the key and then delete it
                while p.next is not None:
                    if p.next.key == key:
                        p.next = p.next.next
                        return
                    p = p.next
                        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)


"""
Test case 1

["MyHashMap","put","put","get","get","put","get", "remove", "get","put","put","put","get","get","get","remove","get","get","get"]
[[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2],[23,230],[3,30],[13,130],[23],[3],[13],[23],[3],[13],[23]]

Test case 2

["MyHashMap","put","put","get","get","put","get", "remove", "get","put","put","put","get","get","get","remove","get","get","get"]
[[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2],[23,230],[3,30],[13,130],[23],[3],[13],[3],[3],[13],[23]]

Test case 3

["MyHashMap","put","put","get","get","put","get", "remove", "get","put","put","put","get","get","get","remove","get","get","get"]
[[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2],[23,230],[3,30],[13,130],[23],[3],[13],[13],[3],[13],[23]]

"""