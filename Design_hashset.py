# Method 1: Linear Chaining using Linked List
# TC: add - O(n) , remove - O(n), contains - O(n) because find function
# SC: O(n)

class Node:
    def __init__(self, key, nextnode = None):
        self.key = key
        self.next = nextnode
class Bucket:
    def __init__(self):
        self.head = Node(0)
        self.tail = self.head
        
    def insert(self, key):
        if not self.find(key):
            nxtnode = Node(key)
            self.tail.next = nxtnode
            self.tail = nxtnode

    def find(self, key):
        ptr = self.head.next
        while ptr:
            if ptr.key == key:
                return True
            ptr = ptr.next
        return False
    
    def delete(self,key):
        ptr = self.head
        while ptr.next != None:
            if ptr.next.key == key:
                tmp = ptr.next
                ptr.next = ptr.next.next
                tmp.next = None
                break
            ptr = ptr.next           

class MyHashSet:

    def __init__(self):
        self.base_modulo = 769
        self.keys_arr = [Bucket() for i in range(self.base_modulo)]
        

    def add(self, key: int) -> None:
        hash_key = key % self.base_modulo
        self.keys_arr[hash_key].insert(key)
        
    def remove(self, key: int) -> None:
        hash_key = key % self.base_modulo
        self.keys_arr[hash_key].delete (key)
        
    def contains(self, key: int) -> bool:
        hash_key = key % self.base_modulo
        return self.keys_arr[hash_key].find(key)
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)


# Method 2: Double hashing using array
# TC: add - O(1) , remove - O(1), contains - O(1) 
# SC: O(n)

class MyHashSet:

    def __init__(self):
        self.H1_HELPER = 1000
        self.H2_HELPER = 1000
        self.bucket = [ ]
        self.keys_arr = [ self.bucket for i in range(self.H1_HELPER)]
        
    def gethash1(self,key):
        return key % self.H1_HELPER
    
    def gethash2(self,key):
        return key // self.H2_HELPER

    def add(self, key: int) -> None:
        if self.contains(key) == False:
            hash1 = self.gethash1(key)
            hash2 = self.gethash2(key)
            if self.keys_arr[hash1] == [ ]:
                self.keys_arr[hash1] = [False for i in range(self.H1_HELPER + 1)]
            self.keys_arr[hash1][hash2] = True
                                    

    def remove(self, key: int) -> None:
        if self.contains(key):
            hash1 = self.gethash1(key)
            hash2 = self.gethash2(key)
            self.keys_arr[hash1][hash2] = False
                   

    def contains(self, key: int) -> bool:
        hash1 = self.gethash1(key)
        hash2 = self.gethash2(key)
        if self.keys_arr[hash1] == [ ]:
            return False
        return self.keys_arr[hash1][hash2]
            
            
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)