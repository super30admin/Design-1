class Node():
    def __init__(self, key, val):
        self.data = (key, val)
        self.next = None    
    
class MyHashMap:
    # Idea is to have a hashmap with buckets indexed by slots, each slot has a linkedlist with data (key, val)
    #we put, get and remove by looking up the key goes in which slot and then add/find/remove the Node indexed by the key 
    # Time Complexity : O(1) best case if chain is of size 1 else in worst case becomes O(n)
    # Space Complexity : O(n)
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.slots = 1000
        self.hashmap = [None]*self.slots        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = key%self.slots
        
        if(self.hashmap[index]==None):
            self.hashmap[index] = Node(key, value)
        else:
            current_node = self.hashmap[index]
            
            while(current_node.next and current_node.data[0]!=key):
                current_node = current_node.next
            
            if(current_node.data[0]==key):
                current_node.data = (key, value) 
            else:
                current_node.next = Node(key, value)

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = key%self.slots
        
        if(self.hashmap[index]==None):
            return -1
        else:
            current_node = self.hashmap[index]
            
            while(current_node.next and current_node.data[0]!=key):
                current_node = current_node.next
            
            if(current_node.data[0]==key):
                return current_node.data[1] 
            else:
                return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = key%self.slots
        
        if(self.hashmap[index]==None):
            return None
        elif(self.hashmap[index].data[0]==key):
            self.hashmap[index] = self.hashmap[index].next
        else:
            current_node = self.hashmap[index]
            prev_node = self.hashmap[index]
            
            while(current_node.next and current_node.data[0]!=key):
                prev_node = current_node
                current_node = current_node.next
            
            if(current_node.data[0]==key):
                prev_node.next = current_node.next
            else:
                return None
