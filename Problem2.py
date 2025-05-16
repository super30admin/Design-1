"""
    Time Complexity: Amortized O(1) for put, get, and remove
    Space Complexity: O(n) for the hash map
    Did this code successfully run on Leetcode: Yes
    Problems faced: No
    Approach:
    - Use a hash function to map the key to an index in the hash map
    - Use a linked list to store the key-value pairs at the index
    - If the key already exists, update the value
    - If the key does not exist, add the key-value pair to the linked list
"""

class MyHashMap:
    
    class Node:
        def __init__(self, value, key):
            self.value = value
            self.key = key
            self.next = None

    def hashFunction(self, key):
        return key % 1000

    def __init__(self):
        self.primary = [self.Node(None, None) for i in range(1000)]

    def put(self, key: int, value: int) -> None:
        index = self.hashFunction(key)
        print("Index is", index, "for ", key)
        head = self.primary[index]
        curr = head.next 
        while curr:
            if curr.key == key:
                curr.value = value 
                return 
            curr = curr.next
        new_node = self.Node(value, key) 
        print("New Node", new_node.value, "Key", new_node.key)
        temp = head.next 
        head.next = new_node 
        new_node.next = temp 


    def get(self, key: int) -> int:
        print("Calling get for ", key)
        index = self.hashFunction(key)
        print("Index is", index, "for key", key)
        head = self.primary[index]
        print("head at ", key, "is", head.key, "head value", head.value, "head next", head.next)
        if head.next is None:
            return -1
        else:
            temp = head.next 
            while temp:
                print("Current key is", temp.key, "current value", temp.value, "next is ", temp.next)
                if temp.key == key:
                    print("returning", temp.value)
                    return temp.value
                temp = temp.next
        return -1

    def remove(self, key: int) -> None:
        index = self.hashFunction(key)
        head = self.primary[index]
        if head.next is None:
            return -1
        else:
            curr = prev = head
            while curr:
                if curr.key == key:
                    prev.next = curr.next
                    curr.next = None
                    return 
                prev = curr
                curr = curr.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
